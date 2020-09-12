package com.revature.assignforce.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.assignforce.beans.Rooms;
import com.revature.assignforce.repos.RoomsRepository;

@Service
@Transactional
public class RoomsServiceImpl implements RoomsService {

	@Autowired
	private RoomsRepository RoomsRepository;
	
	@Override
	public List<Rooms> getAll() {
		return RoomsRepository.findAll();
	}

	@Override
	public Optional<Rooms> findById(int id) {
		return RoomsRepository.findById(id);
	}

	@Override
	public Rooms update(Rooms t) {
		return RoomsRepository.save(t);
	}

	@Override
	public Rooms create(Rooms t) {
		return RoomsRepository.save(t);
	}

	@Override
	public void delete(int id) {
		RoomsRepository.deleteById(id);
	}

}