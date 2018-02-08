package com.myeample.es.all;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.NodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.myeample.es")
@ComponentScan(basePackages = {"com.myeample.es"})
public class Config {
 
	 private static Logger logger = LoggerFactory.getLogger(Config.class);
	 
	 private String elasticsearchHome="C:\\elasticsearch-2.4.6\\";

	 @Bean
	 public NodeBuilder nodeBuilder() {
	     return new NodeBuilder();
	 }
	 @Bean
	    public Client client() {
	        try {
	          
	      
	            Client client = TransportClient.builder().build() .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
	            return client;
	            
	        } catch (final IOException ioex) {
	            logger.error("Cannot create temp dir", ioex);
	            throw new RuntimeException();
	        }
	    }

	    @Bean
	    public ElasticsearchOperations elasticsearchTemplate() {
	        return new ElasticsearchTemplate(client());
	    }
	}