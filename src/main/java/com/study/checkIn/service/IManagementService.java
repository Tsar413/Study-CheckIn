package com.study.checkIn.service;

import com.study.checkIn.entity.ClassesGrades;
import com.study.checkIn.entity.User;

public interface IManagementService {
    User managementAddUserTest(String username, String password, String privilege);

    String managementAddUser(String username, String password, String privilege);

    ClassesGrades managementAddClassTest(String classId, String major, String studentNumber);
}
