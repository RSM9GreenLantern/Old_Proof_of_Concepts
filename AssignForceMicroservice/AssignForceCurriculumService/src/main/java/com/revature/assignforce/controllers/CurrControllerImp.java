package com.revature.assignforce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.assignforce.beans.Curriculum;
import com.revature.assignforce.service.CurrService;
import com.revature.assignforce.service.CurrServiceImpl;


@RestController
@RequestMapping("/Curr")
public class CurrControllerImp implements CurriculumController<Curriculum> {

	@Autowired
	CurrService service;
	
	@Override
	@RequestMapping(method=RequestMethod.GET)
	public List<Curriculum> getAll() {
		
		return service.getAll();
	}

	@Override
	@RequestMapping(value="/CurrID", method=RequestMethod.POST, 
	consumes=MediaType.APPLICATION_JSON_VALUE, 
	produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Curriculum> getByUsername(@RequestBody int id) {
		Optional<Curriculum> c = service.findById(id);
		if(!c.isPresent()) return new ResponseEntity<Curriculum>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Curriculum>(c.get(), HttpStatus.OK);
	}

	@Override
	@RequestMapping(method=RequestMethod.PUT, 
	consumes=MediaType.APPLICATION_JSON_VALUE, 
	produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Curriculum> update(@RequestBody Curriculum c) {
		c = service.update(c);
		if(c == null) return new ResponseEntity<Curriculum>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Curriculum>(c, HttpStatus.CREATED);
	}
	

	@Override
	@RequestMapping(method=RequestMethod.POST, 
	consumes=MediaType.APPLICATION_JSON_VALUE, 
	produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Curriculum> add(@RequestBody Curriculum c) {
		c = service.create(c);
		if(c == null) return new ResponseEntity<Curriculum>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Curriculum>(c, HttpStatus.CREATED);
	}

}
