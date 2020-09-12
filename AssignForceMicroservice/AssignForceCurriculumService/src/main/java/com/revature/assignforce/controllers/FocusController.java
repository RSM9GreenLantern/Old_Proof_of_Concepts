package com.revature.assignforce.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

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

import com.revature.assignforce.beans.Focus;
import com.revature.assignforce.service.FocusService;
import com.revature.assignforce.service.FocusServiceImpl;

@RestController
@RequestMapping("/focus")
public class FocusController implements CurriculumController<Focus> {

	@Autowired
	FocusService service;
	
	@Override
	@RequestMapping(method=RequestMethod.GET)
	public List<Focus> getAll() {
		
		return service.getAll();
	}

	@Override
	@RequestMapping(value="/focusid", method=RequestMethod.POST, 
	consumes=MediaType.APPLICATION_JSON_VALUE, 
	produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Focus> getByUsername(int id) {
		Optional<Focus> c = service.findById(id);
		if(!c.isPresent()) return new ResponseEntity<Focus>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Focus>(c.get(), HttpStatus.OK);
	}

	@Override
	@RequestMapping(method=RequestMethod.PUT, 
	consumes=MediaType.APPLICATION_JSON_VALUE, 
	produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Focus> update(Focus c) {
		c = service.update(c);
		if(c == null) return new ResponseEntity<Focus>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Focus>(c, HttpStatus.CREATED);
	}

	@Override
	@RequestMapping(method=RequestMethod.POST, 
	consumes=MediaType.APPLICATION_JSON_VALUE, 
	produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Focus> add(Focus c) {
		c = service.create(c);
		if(c == null) return new ResponseEntity<Focus>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Focus>(c, HttpStatus.CREATED);
	}
	@RequestMapping(method=RequestMethod.DELETE, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Focus> delete(@RequestBody int id){
			service.delete(id);
			return new ResponseEntity<Focus>(HttpStatus.CREATED);
	}
	

}
