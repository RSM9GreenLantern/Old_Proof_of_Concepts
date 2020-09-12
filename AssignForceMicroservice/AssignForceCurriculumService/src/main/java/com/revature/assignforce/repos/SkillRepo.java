package com.revature.assignforce.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.assignforce.beans.Skills;

@Repository
public interface SkillRepo extends JpaRepository<Skills, Integer>{

}

