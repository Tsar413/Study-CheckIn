package com.study.checkIn.service;

import com.study.checkIn.dto.CheckInURLDTO;
import com.study.checkIn.dto.StudentCheckInDTO;

public interface IStudentCheckInService {
    String studyCheckInReadyTest(String checkInReadyURL);

    CheckInURLDTO studyCheckInReadyDivideURL(String checkInURL);

    String studentCheckInTestCheckIn(String major, String courseName, String checkInName, String studentName, String studentId);

    String studentCheckInCheckIn(String major, String courseName, String checkInName, String studentName, String studentId);
}
