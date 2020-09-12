package com.revature.assignforce.service;

import java.util.List;
import java.util.Optional;

import com.revature.assignforce.beans.Rooms;

public interface RoomsService {
	
	List<Rooms> getAll();
	Optional<Rooms> findById(int id);
	Rooms update(Rooms t);
	Rooms create(Rooms t);
	void delete(int id);
}
