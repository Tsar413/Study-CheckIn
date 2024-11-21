package com.study.checkIn.controller;

import com.study.checkIn.entity.ClassesGrades;
import com.study.checkIn.entity.User;
import com.study.checkIn.service.IManagementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@RestController
public class ManagementAddController {
    @Resource
    private IManagementService iManagementService;

    @GetMapping("/managementAdd")
    public ModelAndView showAHtml() {
        return new ModelAndView("Management/ManagementAdd","time1",0);
    }

    @GetMapping("/managementAdd-userTest")
    public User managementAddUserTest(String username, String password, String privilege){
        return iManagementService.managementAddUserTest(username, password, privilege);
    }

    @GetMapping("/managementAdd-user")
    public String managementAddUser(String username, String password, String privilege){
        return iManagementService.managementAddUser(username, password, privilege);
    }

    @GetMapping("/managementAdd-classTest")
    public ClassesGrades managementAddClassTest(String classId, String major, String studentNumber){
        return iManagementService.managementAddClassTest(classId, major, studentNumber);
    }
}
