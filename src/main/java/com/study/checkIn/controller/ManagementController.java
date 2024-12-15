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

    @GetMapping("/management-checkTeacherCourses")
    public List<ClassesGrades> managementCheckTeacherCourses(String teacherName, String courses){
        return iManagementService.managementCheckTeacherCourses(teacherName, courses);
    }

    @GetMapping("/management-checkCheckIn")
    public List<String> managementCheckCheckIn(String classGradesName, String courses){
        return iManagementService.managementCheckCheckIn(classGradesName, courses);
    }

    @GetMapping("/management-getCheckInURL")
    public String managementGetCheckInURL(String classGradesName, String courses, String checkInName){
        return iManagementService.managementGetCheckInURL(classGradesName, courses, checkInName);
    }

    @GetMapping("/management-changeTeacherName")
    public String managementChangeTeacherName(String oldTeacherName, String newTeacherName){
        return iManagementService.managementChangeTeacherName(oldTeacherName, newTeacherName);
    }

    @GetMapping("/management-changeCourse")
    public Course managementChangeCourse(String id, String courseId, String courseName, String classId, String teacherId, String courseTime){
        return iManagementService.managementChangeCourse(id, courseId, courseName, classId, teacherId, courseTime);
    }
}
