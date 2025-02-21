package com.typeahead.spark_microservice.SparkMicroservice.service;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.springframework.stereotype.Service;

import com.typeahead.spark_microservice.SparkMicroservice.configuration.ApplicationConfig;

@Service
class SparkStreamOrchestrator extends StreamOrchestrator<Dataset<Row>, ApplicationConfig> {

    private final StorageService<Dataset<Row>, ApplicationConfig> storageService;

    SparkStreamOrchestrator(ConsumerService<Dataset<Row>, ApplicationConfig> kafkaToSparkConsumerService,
            StorageService<Dataset<Row>, ApplicationConfig> storageService) {
        super(kafkaToSparkConsumerService);
        this.storageService = storageService;
    }

    @Override
    void sendToStorage(Dataset<Row> wordAndWordCountStream) {
        storageService.upload(wordAndWordCountStream); // TODO Create concrete impl
    }
}
