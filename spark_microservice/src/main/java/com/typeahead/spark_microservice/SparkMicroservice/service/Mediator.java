package com.typeahead.spark_microservice.SparkMicroservice.service;

abstract class Mediator<T, P> {

    final ConsumerService<T, P> consumerService;
    final StorageService<T, P> storageService;

    Mediator(ConsumerService<T, P> consumerService,
            StorageService<T, P> storageService) {
        this.consumerService = consumerService;
        this.storageService = storageService;
    }

    abstract void coordinateConsumerAndStorageInteraction();
}
