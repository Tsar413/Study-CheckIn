package com.study.checkIn.service.impl;

import com.study.checkIn.entity.User;
import com.study.checkIn.mapper.ManagementServiceMapper;
import com.study.checkIn.service.ILoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements ILoginService {

    @Override
    public User testLogin(String username, String password) {
        User user = new User();
        user.setUserId(1);
        user.setUsername(username);
        user.setPassword(password);
        user.setPrivilege(0);
        return user;
    }
}
