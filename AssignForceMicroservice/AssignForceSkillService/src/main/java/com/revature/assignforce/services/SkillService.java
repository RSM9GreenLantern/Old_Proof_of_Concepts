package com.revature.assignforce.services;

import java.util.List;

import com.revature.assignforce.beans.Skill;

public interface SkillService {
	
	public List<Skill> getAll();
	public Skill getSkillById(int id);
	public List<Skill> getSkillByTrainerId(int id);
	public List<Skill> getSkillByCurriculumId(int id);
	public boolean createSkill(Skill in);
}
