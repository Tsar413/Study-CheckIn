package com.study.checkIn.service;

import com.study.checkIn.dto.CreateCheckInDTO;
import com.study.checkIn.dto.StudentDTO;

public interface ICreateTableRequestService {
    Integer managementAddCreateTableRequest1(String tableName);

    Integer managementAddAddStudent(StudentDTO studentDTO);

    Integer managementAddCreateTableRequest2(String courseName, String classGradesName);

    Integer managementAddNewCheckIn(CreateCheckInDTO createCheckInDTO);
}
