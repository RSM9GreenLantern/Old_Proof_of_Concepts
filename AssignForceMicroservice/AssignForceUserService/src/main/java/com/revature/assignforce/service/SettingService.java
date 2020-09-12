package com.revature.assignforce.service;

import com.revature.assignforce.beans.Setting;
import com.revature.assignforce.beans.User;

import java.util.List;
import java.util.Optional;

public interface SettingService {
    List<Setting> getAll();
    Setting add(Setting setting);
    Setting update(Setting setting);
    Optional<Setting> getById(int id);
}

