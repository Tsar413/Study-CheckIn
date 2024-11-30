package com.study.checkIn.service;

import com.study.checkIn.dto.CheckInURLDTO;

public interface IStudentCheckInService {
    String studyCheckInReadyTest(String checkInReadyURL);

    CheckInURLDTO studyCheckInReadyDivideURL(String checkInURL);
}
