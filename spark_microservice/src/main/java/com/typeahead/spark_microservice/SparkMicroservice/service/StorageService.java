package com.typeahead.spark_microservice.SparkMicroservice.service;

abstract class StorageService<T, P> {
    final P properties;

    StorageService(P properties) {
        this.properties = properties;
    }

    abstract void upload(T streamToStore);
}
