package com.revature.assignforce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.assignforce.beans.Batch;
import com.revature.assignforce.service.BatchService;

@RestController
@RequestMapping("/batch")
public class BatchController {

	@Autowired
	BatchService batchService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Batch> getAll(){
		return batchService.getAll();
	}
	
	@RequestMapping(value="/batchid", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> getByUsername(@RequestBody int id){
		Optional<Batch> t = batchService.findById(id);
		if(!t.isPresent()) return new ResponseEntity<Batch>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Batch>(t.get(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> update(@RequestBody Batch b){
			b = batchService.update(b);
			if(b == null) return new ResponseEntity<Batch>(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Batch>(b, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> add(@RequestBody Batch b){
			b = batchService.create(b);
			if(b == null) return new ResponseEntity<Batch>(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Batch>(b, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> delete(@RequestBody int id){
		batchService.delete(id);
			return new ResponseEntity<Batch>(HttpStatus.CREATED);
	}
	
	
	
}
