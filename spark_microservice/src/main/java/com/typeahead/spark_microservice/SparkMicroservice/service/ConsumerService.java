package com.typeahead.spark_microservice.SparkMicroservice.service;

abstract class ConsumerService<T, P> {
    final P properties;

    ConsumerService(P properties) {
        this.properties = properties;
    }

    abstract T ingestWordStream();

    abstract T aggregateByWord(T ingestedStream);

    T currentWordStream() {
        return aggregateByWord(ingestWordStream());
    }
}
