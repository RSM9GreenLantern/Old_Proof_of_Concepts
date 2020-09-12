package com.revature.assignforce.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.revature.assignforce.beans.Focus;
import com.revature.assignforce.repos.FocusRepo;

@Service
@Transactional
public class FocusServiceImpl implements FocusService {

	private FocusRepo focusRepo;
	
	@Override
	public List<Focus> getAll() {
		
		return focusRepo.findAll();
	}

	@Override
	public Optional<Focus> findById(int id) {
		
		return focusRepo.findById(id);
	}

	@Override
	public Focus create(Focus obj) {
		
		return focusRepo.save(obj);
	}

	@Override
	public Focus update(Focus obj) {
		
		return focusRepo.save(obj);
	}
	
	public void delete(int id) {
		 focusRepo.deleteById(id);
	}

}
