package com.ex.CENTENE.JavaKafkaEvents.springboot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ex.CENTENE.JavaKafkaEvents.kafka.producer.Sender;
import com.ex.CENTENE.JavaKafkaEvents.springboot.model.Record;
import com.ex.CENTENE.JavaKafkaEvents.springboot.model.Schema;
import com.ex.CENTENE.JavaKafkaEvents.springboot.service.RecordService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api")
public class RecordController {
	String SCHEMA_REG_URL = "http://localhost:8081/SpringBootRestApi/api/schema/";
	
	public static final Logger logger = LoggerFactory.getLogger(RecordController.class);

	@Autowired
	RecordService recordService;
	
	@Autowired
	Sender kafkaProducer;
	
	@Autowired
	ObjectMapper mapper;
	
	@RequestMapping(value = "/record/", method = RequestMethod.POST)
	public ResponseEntity<?> recordPOST(@RequestBody Record record, UriComponentsBuilder ucBuilder) throws JsonProcessingException {
		logger.info("Recieved Record", record);

		RestTemplate restTemplate = new RestTemplate();
		
		Schema schema = restTemplate.postForObject(SCHEMA_REG_URL, record.mapOfKeyValues(), Schema.class);
		boolean isError = recordService.validateFields(record, schema);
		
		if (isError) { kafkaProducer.send(mapper.writeValueAsString(record), "Error"); }
		else { kafkaProducer.send(mapper.writeValueAsString(record), "Record"); }

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/record/{key}").buildAndExpand(record.valueOfKey()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	
}
