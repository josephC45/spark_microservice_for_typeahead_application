package com.typeahead.spark_microservice.SparkMicroservice.service;

import org.springframework.stereotype.Service;

@Service
class StreamMediator<T, P> extends Mediator<T, P> {

    StreamMediator(ConsumerService<T, P> consumerService,
            StorageService<T, P> storageService) {
        super(consumerService, storageService);
    }

    @Override
    void coordinateConsumerAndStorageInteraction() {
        T ingestedData = consumerService.getProcessedData();
        storageService.upload(ingestedData);
    }
}
