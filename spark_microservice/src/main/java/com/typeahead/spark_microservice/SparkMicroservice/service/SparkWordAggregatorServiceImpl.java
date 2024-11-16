package com.typeahead.spark_microservice.SparkMicroservice.service;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.springframework.stereotype.Service;

@Service
public class SparkWordAggregatorServiceImpl implements SparkWordAggregatorService {

    public Dataset<Row> aggregateWords(Dataset<Row> kafkaStream) {
        return kafkaStream
                .selectExpr("CAST(value AS STRING)")
                .groupBy("word")
                .count();
    }
}
