package com.study.checkIn.service.impl;

import com.study.checkIn.dto.CheckInURLDTO;
import com.study.checkIn.dto.StudentCheckInDTO;
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

    @Override
    public String studentCheckInTestCheckIn(String major, String courseName, String checkInName, String studentName, String studentId) {
        StudentCheckInDTO studentCheckInDTO = new StudentCheckInDTO();
        studentCheckInDTO.setMajor(major);
        studentCheckInDTO.setCourseName(courseName);
        studentCheckInDTO.setCheckInName(checkInName);
        studentCheckInDTO.setStudentName(studentName);
        studentCheckInDTO.setStudentId(Integer.valueOf(studentId));
        return studentCheckInDTO.toString();
    }
}
