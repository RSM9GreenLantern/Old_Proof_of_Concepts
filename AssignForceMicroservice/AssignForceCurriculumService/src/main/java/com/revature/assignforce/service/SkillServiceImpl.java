package com.revature.assignforce.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.revature.assignforce.beans.Skills;
import com.revature.assignforce.repos.SkillRepo;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {

	private SkillRepo skillRepo;
	
	@Override
	public List<Skills> getAll() {
		
		return skillRepo.findAll();
	}

	@Override
	public Optional<Skills> findById(int id) {
	
		return skillRepo.findById(id);
	}

	@Override
	public Skills create(Skills obj) {
		
		return skillRepo.save(obj);
	}

	@Override
	public Skills update(Skills obj) {
		
		return skillRepo.save(obj);
	}

}
