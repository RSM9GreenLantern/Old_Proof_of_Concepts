package com.revature.assignforce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.assignforce.beans.Skill;
import com.revature.assignforce.services.SkillService;

@RestController
public class SkillController {
	
	@Autowired
	private SkillService skillServ;
	
	@RequestMapping(value="/skills", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Skill>> getAll()
	{
		List<Skill> out = skillServ.getAll();
		return new ResponseEntity<List<Skill>>(out , HttpStatus.OK);
	}
	
	@RequestMapping(value="/skills/{id}", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Skill> getById(@PathVariable int id)
	{
		Skill out = skillServ.getSkillById(id);
		if(out != null)
		{
			return new ResponseEntity<Skill>(out , HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<Skill>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/skills/trainer/{id}", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Skill>> getByTrainerId(@PathVariable int id)
	{
		List<Skill> out = skillServ.getSkillByTrainerId(id);
		if(out != null)
		{
			return new ResponseEntity<List<Skill>>(out , HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<List<Skill>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/skills/curriculum/{id}", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Skill>> getByCurriculumId(@PathVariable int id)
	{
		List<Skill> out = skillServ.getSkillByCurriculumId(id);
		if(out != null)
		{
			return new ResponseEntity<List<Skill>>(out , HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<List<Skill>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/skills/new/{name}", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Skill> saveNewSkill(@PathVariable String name)
	{
		
		Skill in = new Skill();
		in.setId(0);
		in.setSkillName(name);
		boolean flag = skillServ.createSkill(in);
		
		if(flag)
		{
			return new ResponseEntity<Skill>(HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<Skill>(HttpStatus.NOT_FOUND);
		}
	}
}
