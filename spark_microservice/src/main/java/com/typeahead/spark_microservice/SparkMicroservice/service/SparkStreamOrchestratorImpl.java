package com.typeahead.spark_microservice.SparkMicroservice.service;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.springframework.stereotype.Service;

@Service
public class SparkStreamOrchestratorImpl implements SparkStreamOrchestrator {

    private final SparkKafkaStreamService kafkaStreamService;
    private final SparkWordAggregatorService wordAggregatorService;

    public SparkStreamOrchestratorImpl(SparkKafkaStreamService kafkaStreamService, SparkWordAggregatorService wordAggregatorService){
        this.kafkaStreamService = kafkaStreamService;
        this.wordAggregatorService = wordAggregatorService;
        // HBase di will go here
    }

    public void start() {
        Dataset<Row> kafkaConsumerStream = kafkaStreamService.createKafkaConsumerStream();
        Dataset<Row> wordsAndWordCounts = wordAggregatorService.aggregateWords(kafkaConsumerStream);
        // will save wordsAndWordCounts to HBase
    }
}
