package com.study.checkIn.controller;

import com.study.checkIn.service.impl.StudentCheckInService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@RestController
public class StudentCheckInController {
    @Resource
    private StudentCheckInService studentCheckInService;

    @GetMapping("/studentCheckIn")
    public ModelAndView showAHtml() {
        return new ModelAndView("StudentCheckIn/StudentCheckIn","time1",0);
    }

    @GetMapping("/studentCheckIn-testCheckIn")
    public String studentCheckInTestCheckIn(String major, String courseName, String checkInName, String studentName, String studentId){
        return studentCheckInService.studentCheckInTestCheckIn(major, courseName, checkInName, studentName, studentId);
    }
}