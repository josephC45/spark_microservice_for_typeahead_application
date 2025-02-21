package com.typeahead.spark_microservice.SparkMicroservice.service;

public class StreamOrchestrator {
    private final Mediator<?, ?> mediator;

    public StreamOrchestrator(Mediator<?, ?> mediator) {
        this.mediator = mediator;
    }

    public void start() {
        mediator.coordinateConsumerAndStorageInteraction();
    }
}
