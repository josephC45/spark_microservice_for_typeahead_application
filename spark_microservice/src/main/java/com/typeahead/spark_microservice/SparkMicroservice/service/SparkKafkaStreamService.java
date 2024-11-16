package com.typeahead.spark_microservice.SparkMicroservice.service;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public interface SparkKafkaStreamService {
    public Dataset<Row> createKafkaConsumerStream();
}
