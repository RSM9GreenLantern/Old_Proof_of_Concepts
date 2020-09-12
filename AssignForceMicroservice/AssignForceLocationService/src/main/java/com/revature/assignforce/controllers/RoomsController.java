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

import com.revature.assignforce.beans.Rooms;
import com.revature.assignforce.service.RoomsService;

@RestController
@RequestMapping("/rooms")
public class RoomsController {

	@Autowired
	RoomsService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Rooms> getAll(){
		return service.getAll();
	}
	
	@RequestMapping(value="/trainerid", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rooms> getByUsername(@RequestBody int id){
		Optional<Rooms> t = service.findById(id);
		if(!t.isPresent()) return new ResponseEntity<Rooms>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Rooms>(t.get(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rooms> update(@RequestBody Rooms t){
			t = service.update(t);
			if(t == null) return new ResponseEntity<Rooms>(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Rooms>(t, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rooms> add(@RequestBody Rooms t){
			t = service.create(t);
			if(t == null) return new ResponseEntity<Rooms>(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Rooms>(t, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rooms> delete(@RequestBody int id){
			service.delete(id);
			return new ResponseEntity<Rooms>(HttpStatus.CREATED);
	}
	
	
	
}
