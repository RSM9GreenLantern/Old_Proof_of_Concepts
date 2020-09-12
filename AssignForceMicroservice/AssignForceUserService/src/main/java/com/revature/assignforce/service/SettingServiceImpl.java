package com.revature.assignforce.service;

import com.revature.assignforce.beans.Setting;
import com.revature.assignforce.beans.User;
import com.revature.assignforce.repos.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SettingServiceImpl implements SettingService {

    @Autowired
    SettingRepository settingRepo;

    @Override
    public List<Setting> getAll() {
        return settingRepo.findAll();
    }

    @Override
    public Setting add(Setting setting) {
        return settingRepo.save(setting);
    }

    @Override
    public Optional<Setting> getById(int id) {
        return settingRepo.findById(id);
    }

    @Override
    public Setting update(Setting setting) {
        return settingRepo.saveAndFlush(setting);
    }
}
