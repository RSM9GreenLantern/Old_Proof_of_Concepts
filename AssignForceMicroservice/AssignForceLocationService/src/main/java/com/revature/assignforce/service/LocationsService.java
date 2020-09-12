package com.revature.assignforce.service;

import java.util.List;
import java.util.Optional;

import com.revature.assignforce.beans.Locations;

public interface LocationsService {
	
	List<Locations> getAll();
	Optional<Locations> findById(int id);
	Locations update(Locations t);
	Locations create(Locations t);
	void delete(int id);
}