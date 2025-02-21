package com.typeahead.spark_microservice.SparkMicroservice.service;

abstract class ConsumerService<T, P> {
    final P properties;

    ConsumerService(P properties) {
        this.properties = properties;
    }

    abstract T ingestData();

    abstract T processData(T ingestedData);

    private T retrieveProcessedData() {
        T ingestedData = ingestData();
        return processData(ingestedData);
    }

    T getProcessedData() {
        return retrieveProcessedData();
    }
}
