package com.study.checkIn.service;

import com.study.checkIn.dto.StudentDTO;

public interface ICreateTableRequestService {
    Integer managementAddCreateTableRequest1(String tableName);

    Integer managementAddAddStudent(StudentDTO studentDTO);
}
