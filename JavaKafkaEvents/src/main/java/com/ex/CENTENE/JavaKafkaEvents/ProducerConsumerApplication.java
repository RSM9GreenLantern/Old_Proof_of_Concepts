package com.ex.CENTENE.JavaKafkaEvents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.ex.CENTENE.JavaKafkaEvents.springboot","com.ex.CENTENE.JavaKafkaEvents.kafka"})
public class ProducerConsumerApplication{

    public static void main(String[] args) {
        SpringApplication.run(ProducerConsumerApplication.class, args);
    }
}