package com.typeahead.spark_microservice.SparkMicroservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaConfig implements ApplicationConfig {

    private String bootstrapServer;
    private String topic;
    private String offset;

    @Override
    public String getBootstrapServers() {
        return bootstrapServer;
    }

    public void setBootstrapServers(String bootstrapServer) {
        this.bootstrapServer = bootstrapServer;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    @Override
    public String getZookeeperQuorum() {
        throw new UnsupportedOperationException("Unimplemented method 'getZookeeperQuorum'");
    }

}
