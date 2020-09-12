package com.revature.assignforce.service;

import java.util.List;
import java.util.Optional;

import com.revature.assignforce.beans.Curriculum;

public interface CurrService {
	List<Curriculum> getAll();
	Optional<Curriculum> findById(int id);
	Curriculum create(Curriculum obj);
	Curriculum update(Curriculum obj);
}
