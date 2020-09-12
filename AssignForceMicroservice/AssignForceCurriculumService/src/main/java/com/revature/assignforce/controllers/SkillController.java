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

import com.revature.assignforce.beans.Skills;
import com.revature.assignforce.service.SkillService;
import com.revature.assignforce.service.SkillServiceImpl;

@RestController
@RequestMapping("/skills")
public class SkillController implements CurriculumController<Skills> {
	
	@Autowired
	SkillService service;

	@Override
	@RequestMapping(method=RequestMethod.GET)
	public List<Skills> getAll() {
		
		return service.getAll();
	}

	@Override
	@RequestMapping(value="/skillid", method=RequestMethod.POST, 
	consumes=MediaType.APPLICATION_JSON_VALUE, 
	produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Skills> getByUsername(int id) {
		Optional<Skills> c = service.findById(id);
		if(!c.isPresent()) return new ResponseEntity<Skills>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Skills>(c.get(), HttpStatus.OK);
	}

	@Override
	@RequestMapping(method=RequestMethod.PUT, 
	consumes=MediaType.APPLICATION_JSON_VALUE, 
	produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Skills> update(Skills c) {
		c = service.update(c);
		if(c == null) return new ResponseEntity<Skills>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Skills>(c, HttpStatus.CREATED);
	}

	@Override
	@RequestMapping(method=RequestMethod.POST, 
	consumes=MediaType.APPLICATION_JSON_VALUE, 
	produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Skills> add(Skills c) {
		c = service.create(c);
		if(c == null) return new ResponseEntity<Skills>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Skills>(c, HttpStatus.CREATED);
	}

}
