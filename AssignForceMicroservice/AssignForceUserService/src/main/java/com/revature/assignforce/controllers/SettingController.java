package com.revature.assignforce.controllers;

import com.revature.assignforce.beans.Setting;
import com.revature.assignforce.service.SettingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SettingController {

    @Autowired
    private SettingService s_service;

    @RequestMapping(method=RequestMethod.POST, value = "/settings",
            consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Setting> add(@RequestBody Setting setting){
        Setting s = s_service.add(setting);
        if(s == null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<>(setting, HttpStatus.CREATED);
    }
    @RequestMapping(method=RequestMethod.GET, value = "/settings",
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Setting>> findAll(){
        return new ResponseEntity<>(s_service.getAll(), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/setting/id/{id}")
    public ResponseEntity<Setting> findById(@PathVariable int id){
    	Optional<Setting> s = s_service.getById(id);
		if(!s.isPresent()) return new ResponseEntity<Setting>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Setting>(s.get(), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/settings",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Setting> update(@RequestBody Setting setting){
        Setting s = s_service.update(setting);
        if(s == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(setting, HttpStatus.OK);
        }
    }
}
