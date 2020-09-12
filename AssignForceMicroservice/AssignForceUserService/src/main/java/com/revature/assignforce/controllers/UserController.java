package com.revature.assignforce.controllers;

import com.revature.assignforce.beans.User;
import com.revature.assignforce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService u_service;

    @RequestMapping(method=RequestMethod.POST, value = "/users",
            consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> add(@RequestBody User user){
        User u = u_service.add(user);
        if(u == null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @RequestMapping(method=RequestMethod.GET, value = "/users",
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> findAll(){
        return new ResponseEntity<>(u_service.getAll(), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/user/id/{id}")
    public ResponseEntity<User> findById(@PathVariable int id){
    	Optional<User> u = u_service.getById(id);
		if(!u.isPresent()) return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<User>(u.get(), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/user/username/{email}")
    public ResponseEntity<User> findByUsername(@PathVariable String email){
        User user = u_service.getByUsername(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/users",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> update(@RequestBody User user){
        User u = u_service.update(user);
        if(u == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }
}
