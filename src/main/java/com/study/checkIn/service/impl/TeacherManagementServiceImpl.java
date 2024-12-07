package com.study.checkIn.service.impl;

import com.study.checkIn.dto.CheckInResultDTO;
import com.study.checkIn.service.ITeacherManagementService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherManagementServiceImpl implements ITeacherManagementService {
    @Override
    public CheckInResultDTO managementCheckInTest(String teacherName, String courseName, String classGradesName, String checkInName) {
        CheckInResultDTO checkInResultDTO = new CheckInResultDTO();
        checkInResultDTO.setTeacherName(teacherName);
        checkInResultDTO.setCourseName(courseName);
        checkInResultDTO.setClassGradesName(classGradesName);
        checkInResultDTO.setCheckInName(checkInName);
        checkInResultDTO.setStudentNumber(0);
        checkInResultDTO.setCheckInNumber(0);
        checkInResultDTO.setNotCheckInNumber(0);
        checkInResultDTO.setNotCheckInStudentList(new ArrayList<String>());
        System.out.println(checkInResultDTO);
        return checkInResultDTO;
    }
}
