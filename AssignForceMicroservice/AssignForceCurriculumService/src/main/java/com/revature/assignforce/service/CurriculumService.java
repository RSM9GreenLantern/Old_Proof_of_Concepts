package com.revature.assignforce.service;

import java.util.List;
import java.util.Optional;

public interface CurriculumService<T> {
	

	List<T> getAll();
	Optional<T> findById(int id);
	T create(T obj);
	T update(T obj);
	
}
