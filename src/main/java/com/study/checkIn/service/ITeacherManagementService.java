package com.study.checkIn.service;

import com.study.checkIn.dto.CheckInResultDTO;

public interface ITeacherManagementService {
     CheckInResultDTO managementCheckInTest(String teacherName, String courseName, String classGradesName, String checkInName);
}
