package com.revature.assignforce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.revature.assignforce.beans.Unavailability;
import com.revature.assignforce.service.AvailabilityService;

@RestController
public class AvailabilityController {
	
	@Autowired
	private AvailabilityService availServ;
	
	@RequestMapping(value="/availability", method=RequestMethod.GET, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Unavailability>> getAll()
	{
		List<Unavailability> out = availServ.getAll();
		return new ResponseEntity<List<Unavailability>>(out,HttpStatus.OK);
	}
	
	@RequestMapping(value="/availability/{id}", method=RequestMethod.GET, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Unavailability> getById(@PathVariable int id)
	{
		Unavailability out = availServ.getById(id);
		if(out != null)
		{
			return new ResponseEntity<Unavailability>(out , HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<Unavailability>(HttpStatus.BAD_REQUEST);
		}	
	}
	
	@RequestMapping(value="/availability/trainer/{id}", method=RequestMethod.GET, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Unavailability>> getByTrainerId(@PathVariable int id)
	{
		List<Unavailability> out = availServ.getByTrainer(id);
		if(out != null)
		{
			return new ResponseEntity<List<Unavailability>>(out , HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<List<Unavailability>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/availability/room/{id}", method=RequestMethod.GET, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Unavailability>> getByRoomId(@PathVariable int id)
	{
		List<Unavailability> out = availServ.getByRoom(id);
		if(out != null)
		{
			return new ResponseEntity<List<Unavailability>>(out , HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<List<Unavailability>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/availability/new/", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Unavailability> saveNewSkill(@RequestBody Unavailability in)
	{
		
		boolean flag = availServ.saveTime(in);
		
		if(flag)
		{
			return new ResponseEntity<Unavailability>(HttpStatus.CREATED);
		}
		else 
		{
			return new ResponseEntity<Unavailability>(HttpStatus.NOT_FOUND);
		}
	}
}
