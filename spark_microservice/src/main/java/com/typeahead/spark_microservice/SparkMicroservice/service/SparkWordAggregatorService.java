package com.typeahead.spark_microservice.SparkMicroservice.service;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public interface SparkWordAggregatorService {
    public Dataset<Row> aggregateWords(Dataset<Row> kafkaStream);
}
