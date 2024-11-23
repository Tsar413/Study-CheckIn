package com.study.checkIn.service;

import com.study.checkIn.entity.ClassesGrades;
import com.study.checkIn.entity.Course;
import com.study.checkIn.entity.User;

import java.util.List;

public interface IManagementService {
    User managementAddUserTest(String username, String password, String privilege);

    String managementAddUser(String username, String password, String privilege);

    ClassesGrades managementAddClassTest(String classId, String major, String studentNumber);

    String managementAddClass(String classId, String major, String studentNumber);

    Course managementAddCourseTest(String courseName, String classGradesName, String teacherName, String courseTime);

    String managementAddCourse(String courseName, String classGradesName, String teacherName, String courseTime);

    List<User> managementAddCheckTeacher(String teacherName);
}
