package com.revature.assignforce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.assignforce.beans.Unavailability;

@Repository
public interface AvailabilityRepository extends JpaRepository<Unavailability,Integer>{
	
	public List<Unavailability> findByTrainerId(int id);
	public List<Unavailability> findByRoomId(int id);
}
