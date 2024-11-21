package com.study.checkIn.controller;

import com.study.checkIn.entity.User;
import com.study.checkIn.service.ILoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    private ILoginService iLoginService;

    @GetMapping("/login")
    public ModelAndView showAHtml() {
        return new ModelAndView("Login","time1",0);
    }

    @GetMapping("/login-test")
    public User loginTest(String username, String password){
        return iLoginService.testLogin(username, password);
    }

}
