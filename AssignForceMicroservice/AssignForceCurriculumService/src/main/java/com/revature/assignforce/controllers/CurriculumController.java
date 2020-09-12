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

@RestController
public interface CurriculumController<T> {

	
	public List<T> getAll();
	
	public ResponseEntity<T> getByUsername( int id);
	
	public ResponseEntity<T> update(T c);
	
	public ResponseEntity<T> add( T c);
	
	
	
}
