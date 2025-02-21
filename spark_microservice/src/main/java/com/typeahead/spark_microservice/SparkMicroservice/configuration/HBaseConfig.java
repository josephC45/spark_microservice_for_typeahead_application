package com.typeahead.spark_microservice.SparkMicroservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "hbase")
public class HBaseConfig implements ApplicationConfig {

    private String bootstrapServers;
    private String zookeeperQuorum;

    @Override
    public String getBootstrapServers() {
        return bootstrapServers;
    }

    @Override
    public String getZookeeperQuorum() {
        return zookeeperQuorum;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public void setZookeeperQuorum(String zookeeperQuorum) {
        this.zookeeperQuorum = zookeeperQuorum;
    }

    @Override
    public String getTopic() {
        throw new UnsupportedOperationException("Unimplemented method 'getTopic'");
    }

    @Override
    public String getOffset() {
        throw new UnsupportedOperationException("Unimplemented method 'getOffset'");
    }

}