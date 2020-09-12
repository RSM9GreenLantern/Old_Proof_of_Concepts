package com.ex.CENTENE.JavaKafkaEvents.springboot.service;

import com.ex.CENTENE.JavaKafkaEvents.springboot.model.Record;
import com.ex.CENTENE.JavaKafkaEvents.springboot.model.Schema;

public interface RecordService {
	boolean validateFields(Record record, Schema schema);
}
