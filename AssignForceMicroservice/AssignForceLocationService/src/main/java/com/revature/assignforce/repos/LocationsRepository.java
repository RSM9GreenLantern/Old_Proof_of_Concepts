package com.revature.assignforce.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.assignforce.beans.Locations;

@Repository
public interface LocationsRepository extends JpaRepository<Locations, Integer>{

}