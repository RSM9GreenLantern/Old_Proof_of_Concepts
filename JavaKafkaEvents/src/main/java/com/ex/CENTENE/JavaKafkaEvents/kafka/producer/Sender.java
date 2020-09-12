package com.ex.CENTENE.JavaKafkaEvents.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service("sender")
public class Sender {

    private static final Logger LOG = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.topic.record}")
    private String recordTopic;
    
    @Value("${app.topic.error}")
    private String errorTopic;

    public void send(String message, String topic){
    	String sendTo = "";
    	switch (topic) {
    		case "Record":
    			sendTo = recordTopic;
    			break;
    			
    		case "Error":
    			sendTo = errorTopic;
    			break;
    	}
    			
        LOG.info("sending message='{}' to topic='{}'", message, sendTo);
        System.out.println("sending message=" + message + "to topic=" + sendTo);
        kafkaTemplate.send(sendTo, message);
    }
}
