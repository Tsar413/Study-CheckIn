package com.study.checkIn.service;

import com.study.checkIn.entity.ClassesGrades;
import com.study.checkIn.entity.Course;
import com.study.checkIn.entity.User;

import java.util.List;

public interface IManagementService {
    List<User> managementGetAllUsers();

        List<Course> managementGetAllCourses();

    List<ClassesGrades> managementGetAllClassesGrades();

    List<Course> managementCheckCourseNames(String teacherName);

    List<ClassesGrades> managementCheckTeacherCourses(String teacherName, String courses);

    List<String> managementCheckCheckIn(String classGradeName, String courses);
}
