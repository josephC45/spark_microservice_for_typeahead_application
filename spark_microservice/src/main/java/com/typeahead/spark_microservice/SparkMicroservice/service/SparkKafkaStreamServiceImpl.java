package com.typeahead.spark_microservice.SparkMicroservice.service;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Service;

import com.typeahead.spark_microservice.SparkMicroservice.configuration.KafkaProperties;

@Service
public class SparkKafkaStreamServiceImpl implements SparkKafkaStreamService {

    private final KafkaProperties kafkaProperties;

    private final SparkSession sparkSession;

    public SparkKafkaStreamServiceImpl(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;

        this.sparkSession = SparkSession.builder()
                .appName("StructuredWordAggregator")
                .master("local[1]")
                .getOrCreate();
    }

    public Dataset<Row> createKafkaConsumerStream() {
        return sparkSession
                .readStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", kafkaProperties.getBootstrapServer())
                .option("subscribe", kafkaProperties.getTopic())
                .option("startingOffsets", kafkaProperties.getOffset())
                .load();
    }
}
