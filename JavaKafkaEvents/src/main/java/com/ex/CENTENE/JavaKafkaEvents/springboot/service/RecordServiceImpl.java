package com.ex.CENTENE.JavaKafkaEvents.springboot.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ex.CENTENE.JavaKafkaEvents.springboot.model.Record;
import com.ex.CENTENE.JavaKafkaEvents.springboot.model.Schema;

@Service("recordService")
public class RecordServiceImpl implements RecordService {

	@Override
	public boolean validateFields(Record record, Schema schema) {
		boolean isError = false;
		
		for (Map.Entry<String,String> entry : schema.getBody().entrySet()) {
            if (! record.getBody().containsKey(entry.getKey())) {
            	isError = true;
            }
		}
		return isError;
	}
	
}
