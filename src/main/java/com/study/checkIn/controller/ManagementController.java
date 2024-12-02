package com.study.checkIn.controller;

import com.study.checkIn.entity.ClassesGrades;
import com.study.checkIn.entity.Course;
import com.study.checkIn.entity.User;
import com.study.checkIn.service.IManagementAddService;
import com.study.checkIn.service.IManagementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ManagementController {
    @Resource
    private IManagementService iManagementService;

    @Resource
    private IManagementAddService iManagementAddService;

    @GetMapping("/management")
    public ModelAndView showAHtml() {
        return new ModelAndView("Management/Management","time1",0);
    }

    @GetMapping("/management-getAllUsers")
    public List<User> managementGetAllUsers(){
        return iManagementService.managementGetAllUsers();
    }

    @GetMapping("/management-getAllCourses")
    public List<Course> managementGetAllCourses(){
        return iManagementService.managementGetAllCourses();
    }

    @GetMapping("/management-getAllClassesGrades")
    public List<ClassesGrades> managementGetAllClassesGrades(){
        return iManagementService.managementGetAllClassesGrades();
    }

    @GetMapping("/management-checkTeacher")
    public List<User> managementCheckTeacher(String teacherName){
        return iManagementAddService.managementAddCheckTeacher(teacherName);
    }

    @GetMapping("/management-checkCourses")
    public List<Course> managementCheckCourses(String teacherName){
        return iManagementService.managementCheckCourseNames(teacherName);
    }
}
