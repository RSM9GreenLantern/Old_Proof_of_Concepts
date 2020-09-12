package com.ex.CENTENE.JavaKafkaEvents.springboot.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class Record {
	private Map<String, String> Key;

	private String Source;

	private String Event;

	private Map<String, Object> Body;

	public Record(){
	}

	public Record(Map<String, String> key, String source, String event, Map<String,Object> body){
		this.Key = key;
		this.Source = source;
		this.Event = event;
		this.Body = body;
	}

	public Map<String, String> getKey() {
		return this.Key;
	}

	public void setKey(Map<String, String> key) {
		this.Key = key;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		this.Source = source;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		this.Event = event;
	}
	
	public Map<String,Object> getBody() {
		return Body;
	}

	public void setBody(Map<String,Object> body) {
		this.Body = body;
	}
	
	public String valueOfKey() {
		return this.Key.get("oid");
	}
	
	public Map<String, Object> mapOfKeyValues(){
		Map<String, Object> keyValues = new HashMap<String, Object>();
		Field[] fields = Record.class.getDeclaredFields();
        for (Field field : fields) {
        	if (!field.getName().equals("Body") && !field.getName().equals("Key")) {
        		field.setAccessible(true);
        		try {
					keyValues.put(field.getName(), field.get(this));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
        	}
        }
        return keyValues;
	}

}
