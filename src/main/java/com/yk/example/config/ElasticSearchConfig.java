package com.yk.example.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import javax.annotation.Resource;

/**
 * Created by yk on 16/3/18.
 */
@Configuration
@PropertySource("classpath:elasticsearch.properties")
@EnableElasticsearchRepositories(basePackages = "com.yk.example.repository.elasticsearch")
public class ElasticsearchConfig {

    @Resource
    private Environment environment;
    @Bean
    public Client client() {
        TransportClient client = new TransportClient();
        TransportAddress address = new InetSocketTransportAddress(
                environment.getProperty("elasticsearch.host"),
                Integer.parseInt(environment.getProperty("elasticsearch.port")));
        client.addTransportAddress(address);
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }

}
