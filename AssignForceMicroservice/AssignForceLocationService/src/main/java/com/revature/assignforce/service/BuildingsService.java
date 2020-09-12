package com.revature.assignforce.service;

import java.util.List;
import java.util.Optional;

import com.revature.assignforce.beans.Buildings;

public interface BuildingsService {
	
	List<Buildings> getAll();
	Optional<Buildings> findById(int id);
	Buildings update(Buildings t);
	Buildings create(Buildings t);
	void delete(int id);
}
