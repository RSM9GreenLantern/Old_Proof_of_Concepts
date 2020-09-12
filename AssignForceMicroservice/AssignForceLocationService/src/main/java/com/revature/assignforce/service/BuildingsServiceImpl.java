package com.revature.assignforce.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.assignforce.beans.Buildings;
import com.revature.assignforce.repos.BuildingsRepository;

@Service
@Transactional
public class BuildingsServiceImpl implements BuildingsService {

	@Autowired
	private BuildingsRepository BuildingsRepository;
	
	@Override
	public List<Buildings> getAll() {
		return BuildingsRepository.findAll();
	}

	@Override
	public Optional<Buildings> findById(int id) {
		return BuildingsRepository.findById(id);
	}

	@Override
	public Buildings update(Buildings t) {
		return BuildingsRepository.save(t);
	}

	@Override
	public Buildings create(Buildings t) {
		return BuildingsRepository.save(t);
	}

	@Override
	public void delete(int id) {
		BuildingsRepository.deleteById(id);
	}

}