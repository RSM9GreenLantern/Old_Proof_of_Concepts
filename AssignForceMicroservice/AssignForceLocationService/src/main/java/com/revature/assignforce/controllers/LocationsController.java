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

import com.revature.assignforce.beans.Locations;
import com.revature.assignforce.service.LocationsService;

@RestController
@RequestMapping("/locations")
public class LocationsController {

	@Autowired
	LocationsService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Locations> getAll(){
		return service.getAll();
	}
	
	@RequestMapping(value="/trainerid", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Locations> getByUsername(@RequestBody int id){
		Optional<Locations> t = service.findById(id);
		if(!t.isPresent()) return new ResponseEntity<Locations>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Locations>(t.get(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Locations> update(@RequestBody Locations t){
			t = service.update(t);
			if(t == null) return new ResponseEntity<Locations>(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Locations>(t, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Locations> add(@RequestBody Locations t){
			t = service.create(t);
			if(t == null) return new ResponseEntity<Locations>(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Locations>(t, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Locations> delete(@RequestBody int id){
			service.delete(id);
			return new ResponseEntity<Locations>(HttpStatus.CREATED);
	}
	
	
	
}
