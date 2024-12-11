package com.study.checkIn.service;

import com.study.checkIn.dto.CheckInResultDTO;
import com.study.checkIn.dto.CreateCheckInDTO;
import com.study.checkIn.entity.ClassesGrades;
import com.study.checkIn.entity.Course;

import java.util.List;

public interface ITeacherManagementService {
     CheckInResultDTO managementCheckInTest(String teacherName, String courseName, String classGradesName, String checkInName);

     List<Course> teacherManagementCheckInCourses(String teacherName);

     List<ClassesGrades> teacherManagementCheckInClassGrades(String teacherName, String courseName);

     List<String> teacherManagementCheckInCheckInName(String classGradesName, String courseName);

     String teacherManagementAddNewCheckIn(CreateCheckInDTO createCheckInDTO);
}
