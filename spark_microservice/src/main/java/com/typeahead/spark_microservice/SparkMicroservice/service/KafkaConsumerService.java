package com.typeahead.spark_microservice.SparkMicroservice.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaConsumerService {
    public void listenToKafkaTopic(ConsumerRecord<String, String> record);
}
