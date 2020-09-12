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

import com.revature.assignforce.beans.Buildings;
import com.revature.assignforce.service.BuildingsService;

@RestController
@RequestMapping("/buildings")
public class BuildingsController {

	@Autowired
	BuildingsService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Buildings> getAll(){
		return service.getAll();
	}
	
	@RequestMapping(value="/trainerid", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Buildings> getByUsername(@RequestBody int id){
		Optional<Buildings> t = service.findById(id);
		if(!t.isPresent()) return new ResponseEntity<Buildings>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Buildings>(t.get(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Buildings> update(@RequestBody Buildings t){
			t = service.update(t);
			if(t == null) return new ResponseEntity<Buildings>(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Buildings>(t, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Buildings> add(@RequestBody Buildings t){
			t = service.create(t);
			if(t == null) return new ResponseEntity<Buildings>(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Buildings>(t, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Buildings> delete(@RequestBody int id){
			service.delete(id);
			return new ResponseEntity<Buildings>(HttpStatus.CREATED);
	}
	
	
	
}
