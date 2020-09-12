package com.revature.assignforce.service;

import com.revature.assignforce.beans.User;
import com.revature.assignforce.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepo;

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User add(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getById(int id) {
        return userRepo.findById(id);
    }

    @Override
    public User getByUsername(String email) {
        return userRepo.findUserByEmailLike(email);
    }

    @Override
    public User update(User user) {
        return userRepo.saveAndFlush(user);
    }
}
