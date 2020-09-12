package com.revature.assignforce.service;

import java.util.List;
import java.util.Optional;

import com.revature.assignforce.beans.Skills;



public interface SkillService {
	List<Skills> getAll();
	Optional<Skills> findById(int id);
	Skills create(Skills obj);
	Skills update(Skills obj);
}
