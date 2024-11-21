package com.study.checkIn.service;

import com.study.checkIn.entity.User;

public interface ILoginService {
    User testLogin(String username, String password);
}
