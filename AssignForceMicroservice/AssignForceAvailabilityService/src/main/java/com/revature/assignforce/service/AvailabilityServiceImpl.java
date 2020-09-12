package com.revature.assignforce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.assignforce.beans.Unavailability;
import com.revature.assignforce.repository.AvailabilityRepository;

@Service
@Transactional
public class AvailabilityServiceImpl implements AvailabilityService {

	
	@Autowired
	private AvailabilityRepository availRepo;
	
	@Override
	public List<Unavailability> getAll() {
		return availRepo.findAll();
	}

	@Override
	public Unavailability getById(int id) {
		return availRepo.getOne(id);
	}

	@Override
	public List<Unavailability> getByRoom(int id) {
		return availRepo.findByRoomId(id);
	}

	@Override
	public List<Unavailability> getByTrainer(int id) {
		return availRepo.findByTrainerId(id);
	}

	@Override
	public boolean saveTime(Unavailability in) {
		
		Unavailability check = availRepo.save(in);
		
		if(check.getId() > 0) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
