package com.study.checkIn.controller;

import com.study.checkIn.dto.CheckInResultDTO;
import com.study.checkIn.dto.CreateCheckInDTO;
import com.study.checkIn.dto.StudentCheckInDTO;
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

    @GetMapping("/teacherManagement-checkInCheckInName")
    public List<String> teacherManagementCheckInCheckInName(String classGradesName, String courseName){
        return iTeacherManagementService.teacherManagementCheckInCheckInName(classGradesName, courseName);
    }

    @GetMapping("/teacherManagement-addNewCheckIn")
    public String teacherManagementAddNewCheckIn(String classGradesName, String courseName, String checkInName){
        CreateCheckInDTO createCheckInDTO = new CreateCheckInDTO(classGradesName + courseName, checkInName);
        return iTeacherManagementService.teacherManagementAddNewCheckIn(createCheckInDTO);
    }

    @GetMapping("/teacherManagement-changeCheckIn")
    public String teacherManagementChangeCheckIn(String major, String courseName, String checkInName, String studentName, String studentId){
        return iTeacherManagementService.teacherManagementChangeCheckIn(major, courseName, checkInName, studentName, studentId);
    }
}
