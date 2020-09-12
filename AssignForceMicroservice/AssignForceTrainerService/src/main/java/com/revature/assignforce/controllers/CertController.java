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

import com.revature.assignforce.beans.Cert;
import com.revature.assignforce.service.CertService;

@RestController
@RequestMapping("/certs")
public class CertController {

	@Autowired
	CertService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Cert> getAll(){
		return service.getAll();
	}
	
	@RequestMapping(value="/trainerid", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cert> getByUsername(@RequestBody int id){
		Optional<Cert> c = service.findById(id);
		if(!c.isPresent()) return new ResponseEntity<Cert>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Cert>(c.get(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cert> update(@RequestBody Cert c){
			c = service.update(c);
			if(c == null) return new ResponseEntity<Cert>(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Cert>(c, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cert> add(@RequestBody Cert c){
			c = service.create(c);
			if(c == null) return new ResponseEntity<Cert>(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Cert>(c, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cert> delete(@RequestBody int id){
			service.delete(id);
			return new ResponseEntity<Cert>(HttpStatus.CREATED);
	}
}
