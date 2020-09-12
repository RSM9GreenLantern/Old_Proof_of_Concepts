package com.revature.assignforce.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.assignforce.beans.Locations;
import com.revature.assignforce.repos.LocationsRepository;

@Service
@Transactional
public class LocationsServiceImpl implements LocationsService {

	@Autowired
	private LocationsRepository LocationsRepository;
	
	@Override
	public List<Locations> getAll() {
		return LocationsRepository.findAll();
	}

	@Override
	public Optional<Locations> findById(int id) {
		return LocationsRepository.findById(id);
	}

	@Override
	public Locations update(Locations t) {
		return LocationsRepository.save(t);
	}

	@Override
	public Locations create(Locations t) {
		return LocationsRepository.save(t);
	}

	@Override
	public void delete(int id) {
		LocationsRepository.deleteById(id);
	}

}