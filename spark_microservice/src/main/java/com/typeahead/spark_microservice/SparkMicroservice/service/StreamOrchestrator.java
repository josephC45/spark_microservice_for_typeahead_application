package com.typeahead.spark_microservice.SparkMicroservice.service;
//TODO Maybe consider mediator pattern?
public abstract class StreamOrchestrator<T, P> {

    private final ConsumerService<T, P> consumerService;

    StreamOrchestrator(ConsumerService<T, P> consumerService) {
        this.consumerService = consumerService;
    }

    abstract void sendToStorage(T wordAndWordCountStream);

    public void start() {
        sendToStorage(consumerService.getProcessedData());
    }
}
