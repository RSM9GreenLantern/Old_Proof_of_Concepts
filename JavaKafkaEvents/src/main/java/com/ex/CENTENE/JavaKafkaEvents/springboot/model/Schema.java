package com.ex.CENTENE.JavaKafkaEvents.springboot.model;

import java.util.HashMap;
import java.util.Map;

public class Schema {
	private Map<String,String> body = new HashMap<String,String>();
	
	public Schema() {
	}

	public Map<String,String> getBody() {
		return this.body;
	}
	
	public void setBody(Map<String,String> body) {
		this.body = body;
	}
	
}
