package com.typeahead.spark_microservice.SparkMicroservice.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    @Override
    @KafkaListener
    public void listenToKafkaTopic(ConsumerRecord<String, String> record) {
        String prefix = record.value();

        // TODO Implement the spark service and call spark service on following line
        // passing

    }
}
