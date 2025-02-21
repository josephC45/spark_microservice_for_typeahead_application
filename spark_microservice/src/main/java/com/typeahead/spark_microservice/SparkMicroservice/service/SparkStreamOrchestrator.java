package com.typeahead.spark_microservice.SparkMicroservice.service;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.springframework.stereotype.Service;

import com.typeahead.spark_microservice.SparkMicroservice.configuration.ApplicationConfig;

@Service
class SparkStreamOrchestrator extends StreamOrchestrator<Dataset<Row>, ApplicationConfig> {

    private final UploadToStorageService<Dataset<Row>, ApplicationConfig> uploadToStorageService;

    SparkStreamOrchestrator(ConsumerService<Dataset<Row>, ApplicationConfig> kafkaToSparkConsumerService,
            UploadToStorageService<Dataset<Row>, ApplicationConfig> uploadToStorageService) {
        super(kafkaToSparkConsumerService);
        this.uploadToStorageService = uploadToStorageService;
    }

    @Override
    void sendToStorage(Dataset<Row> wordAndWordCountStream) {
        uploadToStorageService.upload(wordAndWordCountStream); // TODO Create concrete impl
    }
}
