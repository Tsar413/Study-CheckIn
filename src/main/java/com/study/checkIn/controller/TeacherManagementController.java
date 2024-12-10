package com.study.checkIn.controller;

import com.study.checkIn.dto.CheckInResultDTO;
import com.study.checkIn.entity.ClassesGrades;
import com.study.checkIn.entity.Course;
import com.study.checkIn.entity.User;
import com.study.checkIn.service.ITeacherManagementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TeacherManagementController {
    @Resource
    private ITeacherManagementService iTeacherManagementService;

    @GetMapping("/teacherManagement")
    public ModelAndView showAHtml() {
        return new ModelAndView("Teacher/TeacherManagement","time1",0);
    }

    @GetMapping("/teacherManagement-checkInTest")
    public CheckInResultDTO teacherManagementCheckInTest(String teacherName, String courseName, String classGradesName, String checkInName){
        return iTeacherManagementService.managementCheckInTest(teacherName, courseName, classGradesName, checkInName);
    }

    @GetMapping("/teacherManagement-checkInCourses")
    public List<Course> teacherManagementCheckInCourses(String teacherName){
        return iTeacherManagementService.teacherManagementCheckInCourses(teacherName);
    }

    @GetMapping("/teacherManagement-checkInClassGrades")
    public List<ClassesGrades> teacherManagementCheckInClassGrades(String teacherName, String courseName){
        return iTeacherManagementService.teacherManagementCheckInClassGrades(teacherName, courseName);
    }
}
