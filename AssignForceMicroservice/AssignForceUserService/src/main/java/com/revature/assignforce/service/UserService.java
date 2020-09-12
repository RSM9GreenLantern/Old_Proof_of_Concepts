package com.revature.assignforce.service;

import com.revature.assignforce.beans.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    User add(User user);
    Optional<User> getById(int id);
    User getByUsername(String email);
    User update(User user);
}
