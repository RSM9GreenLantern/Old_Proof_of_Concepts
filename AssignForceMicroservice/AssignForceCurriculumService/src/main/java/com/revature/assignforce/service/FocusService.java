package com.revature.assignforce.service;

import java.util.List;
import java.util.Optional;
import com.revature.assignforce.beans.Focus;

public interface FocusService {
	List<Focus> getAll();
	Optional<Focus> findById(int id);
	Focus create(Focus obj);
	Focus update(Focus obj);
	void delete(int id);
}
