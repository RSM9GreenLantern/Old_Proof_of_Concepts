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

import com.revature.assignforce.beans.Trainer;
import com.revature.assignforce.service.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

	@Autowired
	TrainerService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Trainer> getAll(){
		return service.getAll();
	}
	
	@RequestMapping(value="/trainerid", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Trainer> getByUsername(@RequestBody int id){
		Optional<Trainer> t = service.findById(id);
		if(!t.isPresent()) return new ResponseEntity<Trainer>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Trainer>(t.get(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Trainer> update(@RequestBody Trainer t){
			t = service.update(t);
			if(t == null) return new ResponseEntity<Trainer>(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Trainer>(t, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Trainer> add(@RequestBody Trainer t){
			t = service.create(t);
			if(t == null) return new ResponseEntity<Trainer>(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Trainer>(t, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Trainer> delete(@RequestBody int id){
			service.delete(id);
			return new ResponseEntity<Trainer>(HttpStatus.CREATED);
	}
	
	
	
}
