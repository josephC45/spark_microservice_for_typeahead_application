package com.typeahead.spark_microservice.SparkMicroservice.service;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Service;

import com.typeahead.spark_microservice.SparkMicroservice.configuration.KafkaProperties;

@Service
public class SparkServiceImpl implements SparkService {

    private final KafkaProperties kafkaProperties;

    private final SparkSession sparkSession;

    // Will be injecting HBase service dependency
    public SparkServiceImpl(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;

        this.sparkSession = SparkSession.builder()
                .appName("StructuredWordAggregator")
                .master("local[1]")
                .getOrCreate();
    }

    @Override
    public void start() {
        Dataset<Row> kafkaConsumerStream = createKafkaConsumerStream();
        Dataset<Row> wordsAndWordCounts = aggregateWords(kafkaConsumerStream);
        // will save wordsAndWordCounts to HBase
    }

    private Dataset<Row> createKafkaConsumerStream() {
        return sparkSession
                .readStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", kafkaProperties.getBootstrapServer())
                .option("subscribe", kafkaProperties.getTopic())
                .option("startingOffsets", kafkaProperties.getOffset())
                .load();
    }

    private Dataset<Row> aggregateWords(Dataset<Row> kafkaStream) {
        return kafkaStream
                .selectExpr("CAST(value AS STRING)")
                .groupBy("word")
                .count();
    }
}
