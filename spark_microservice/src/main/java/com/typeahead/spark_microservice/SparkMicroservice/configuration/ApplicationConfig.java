package com.typeahead.spark_microservice.SparkMicroservice.configuration;

public interface ApplicationConfig {
    String getBootstrapServers();

    String getZookeeperQuorum();

    String getTopic();

    String getOffset();
}