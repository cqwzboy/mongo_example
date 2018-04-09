package org.springframework.mongodb;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.UnknownHostException;

@Configuration
public class AppConfig {

    public @Bean MongoClient mongoClient(){
        try {
            return new MongoClient("localhost", 27017);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return null;
    }

    public @Bean MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoClient(), "person");
    }

}
