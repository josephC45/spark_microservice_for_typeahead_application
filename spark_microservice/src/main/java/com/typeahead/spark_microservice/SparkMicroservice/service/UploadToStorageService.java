package com.typeahead.spark_microservice.SparkMicroservice.service;

abstract class UploadToStorageService<T, P> {
    final P properties;

    UploadToStorageService(P properties) {
        this.properties = properties;
    }

    abstract void upload(T streamToStore);
}
