package com.typeahead.spark_microservice.SparkMicroservice.service;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.typeahead.spark_microservice.SparkMicroservice.configuration.ApplicationConfig;

@Service
class KafkaToSparkConsumerServiceImpl extends ConsumerService<Dataset<Row>, ApplicationConfig> {
    final SparkSession sparkSession;

    KafkaToSparkConsumerServiceImpl(@Qualifier("KafkaConfig") ApplicationConfig consumerConfig) {
        super(consumerConfig);
        this.sparkSession = SparkSession.builder()
                .appName("StructuredWordAggregator")
                .master("local[1]")
                .getOrCreate();
    }

    @Override
    Dataset<Row> ingestData() {
        return sparkSession
                .readStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", properties.getBootstrapServers())
                .option("subscribe", properties.getTopic())
                .option("startingOffsets", properties.getOffset())
                .load();
    }

    @Override
    Dataset<Row> processData(Dataset<Row> ingestedStream) {
        return ingestedStream
                .selectExpr("CAST(value AS STRING) AS word")
                .groupBy("word")
                .count();
    }
}
