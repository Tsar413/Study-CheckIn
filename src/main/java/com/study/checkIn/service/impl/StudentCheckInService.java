package com.study.checkIn.service.impl;

import com.study.checkIn.dto.CheckInURLDTO;
import com.study.checkIn.service.IStudentCheckInService;
import com.study.checkIn.utils.DivideURL;
import org.springframework.stereotype.Service;

@Service
public class StudentCheckInService implements IStudentCheckInService {
    @Override
    public String studyCheckInReadyTest(String checkInReadyURL) {
        return checkInReadyURL;
    }

    @Override
    public CheckInURLDTO studyCheckInReadyDivideURL(String checkInURL) {
        return DivideURL.divideCheckInURL(checkInURL);
    }
}
