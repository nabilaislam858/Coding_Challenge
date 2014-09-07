package com.nabila.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.nabila.repository.ResultRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = ResultRepository.class)
public class ApplicationConfig {

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        String mongoDbHost = "127.0.0.1";
        int mongoDbPort = 27017;
        Mongo mongo = new Mongo(mongoDbHost, mongoDbPort);
        String databaseName = "resultdb";
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo, databaseName);
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
        return mongoTemplate;
    }

}
