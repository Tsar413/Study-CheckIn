package com.study.checkIn.controller;

import com.study.checkIn.dto.CreateCheckInDTO;
import com.study.checkIn.dto.StudentDTO;
import com.study.checkIn.entity.ClassesGrades;
import com.study.checkIn.entity.Course;
import com.study.checkIn.entity.User;
import com.study.checkIn.service.ICreateTableRequestService;
import com.study.checkIn.service.IManagementAddService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ManagementAddController {
    @Resource
    private IManagementAddService iManagementAddService;

    @Resource
    private ICreateTableRequestService iCreateTableRequestService;

    @GetMapping("/managementAdd")
    public ModelAndView showAHtml() {
        return new ModelAndView("Management/ManagementAdd","time1",0);
    }

    @GetMapping("/managementAdd-userTest")
    public User managementAddUserTest(String username, String password, String privilege){
        return iManagementAddService.managementAddUserTest(username, password, privilege);
    }

    @GetMapping("/managementAdd-user")
    public String managementAddUser(String username, String password, String privilege){
        return iManagementAddService.managementAddUser(username, password, privilege);
    }

    @GetMapping("/managementAdd-classTest")
    public ClassesGrades managementAddClassTest(String classId, String major, String studentNumber){
        return iManagementAddService.managementAddClassTest(classId, major, studentNumber);
    }

    @GetMapping("/managementAdd-class")
    public String managementAddClass(String classId, String major, String studentNumber){
        return iManagementAddService.managementAddClass(classId, major, studentNumber);
    }

    @GetMapping("/managementAdd-courseTest")
    public Course managementAddCourseTest(String courseName, String classGradesName, String teacherName, String courseTime){
        return iManagementAddService.managementAddCourseTest(courseName, classGradesName, teacherName, courseTime);
    }

    @GetMapping("/managementAdd-course")
    public String managementAddCourse(String courseName, String classGradesName, String teacherName, String courseTime){
        return iManagementAddService.managementAddCourse(courseName, classGradesName, teacherName, courseTime);
    }

    @GetMapping("/managementAdd-checkTeacher")
    public List<User> managementAddCheckTeacher(String teacherName){
        return iManagementAddService.managementAddCheckTeacher(teacherName);
    }

    @GetMapping("/managementAdd-checkClassGrades")
    public List<ClassesGrades> managementAddCheckClassGrades(String classGradesName){
        return iManagementAddService.managementAddCheckClassGrades(classGradesName);
    }

    @GetMapping("/managementAdd-createTableRequest1")
    public String managementAddCreateTableRequest1(String courseName, String classGradesName){
        return String.valueOf(iCreateTableRequestService.managementAddCreateTableRequest1(courseName + classGradesName));
    }

    @GetMapping("/managementAdd-createTableRequest2")
    public String managementAddCreateTableRequest2(String courseName, String classGradesName){
        return String.valueOf(iCreateTableRequestService.managementAddCreateTableRequest2(courseName, classGradesName));
    }

    @GetMapping("/managementAdd-createTableRequestStudent")
    public String managementAddCreateTableRequestStudent(String classGradesName){
        return String.valueOf(iCreateTableRequestService.managementAddCreateTableRequest1(classGradesName + "Student"));
    }

    @GetMapping("/managementAdd-addStudent")
    public String managementAddAddStudent(String classGradesName, String studentId, String studentName){
        StudentDTO studentDTO = new StudentDTO(null, Integer.parseInt(studentId), studentName, classGradesName + "Student");
        return String.valueOf(iCreateTableRequestService.managementAddAddStudent(studentDTO));
    }

    @GetMapping("/managementAdd-addCheckInTestStep1")
    public List<Course> managementAddAddCheckInTestStep1(String classGradesName){
        return iManagementAddService.managementAddAddCheckInTestStep1(classGradesName);
    }

    @GetMapping("/managementAdd-addCheckCourseTable")
    public String managementAddAddCheckCourseTable(String classGradesName, String courseName){
        return iManagementAddService.managementAddAddCheckCourseTable(classGradesName, courseName);
    }

    @GetMapping("/managementAdd-addNewCheckIn")
    public String managementAddAddNewCheckIn(String classGradesName, String courseName, String checkInName){
        System.out.println(iManagementAddService.managementAddAddCheckCourseTable(classGradesName, courseName));
        CreateCheckInDTO createCheckInDTO = new CreateCheckInDTO(classGradesName + courseName, checkInName);
        return String.valueOf(iCreateTableRequestService.managementAddNewCheckIn(createCheckInDTO));
    }
}
