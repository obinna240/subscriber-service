package com.brownbag.news.subscriberservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Profile("prodmysql")
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.brownbag.news.subscriberservice.repository")
public class SubscriberServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubscriberServiceApplication.class, args);
    }

}
