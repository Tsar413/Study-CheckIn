package com.study.checkIn.service.impl;

import com.study.checkIn.dto.CheckInResultDTO;
import com.study.checkIn.dto.StudentDTO;
import com.study.checkIn.service.ITeacherManagementService;
import com.study.checkIn.utils.SQLConstants;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherManagementServiceImpl implements ITeacherManagementService {
    private final JdbcTemplate jdbcTemplate;

    public TeacherManagementServiceImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public CheckInResultDTO managementCheckInTest(String teacherName, String courseName, String classGradesName, String checkInName) {
        CheckInResultDTO checkInResultDTO = new CheckInResultDTO();
        checkInResultDTO.setTeacherName(teacherName);
        checkInResultDTO.setCourseName(courseName);
        checkInResultDTO.setClassGradesName(classGradesName);
        checkInResultDTO.setCheckInName(checkInName);
        Integer studentNumber = getStudentNumber(classGradesName, courseName);
        if(studentNumber == -1){
            return null;
        }
        checkInResultDTO.setStudentNumber(studentNumber);
        Integer checkInNumber = getCheckInNumber(classGradesName, courseName, checkInName);
        if(checkInNumber == -1){
            return null;
        }
        checkInResultDTO.setCheckInNumber(checkInNumber);
        Integer notCheckInNumber = getNotCheckInNumber(classGradesName, courseName, checkInName);
        if(notCheckInNumber == -1){
            return null;
        }
        checkInResultDTO.setNotCheckInNumber(notCheckInNumber);
        checkInResultDTO.setNotCheckInStudentList(getNotCheckInList(classGradesName, courseName, checkInName));
        System.out.println(checkInResultDTO);
        return checkInResultDTO;
    }

    private Integer getStudentNumber(String classGradesName, String courseName){
        Integer result = 0;
        String sql1 = SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL8 + classGradesName + courseName +
                SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL9;
        try {
            result = jdbcTemplate.queryForObject(sql1, Integer.class);
        } catch (DataAccessException e) {
            return -1;
        }
        return result;
    }

    private Integer getCheckInNumber(String classGradesName, String courseName, String checkInName){
        Integer result = 0;
        String sql1 = SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL8 + classGradesName + courseName +
                SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL10 + checkInName +
                SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL11;
        try {
            result = jdbcTemplate.queryForObject(sql1, Integer.class);
        } catch (DataAccessException e) {
            return -1;
        }
        return result;
    }

    private Integer getNotCheckInNumber(String classGradesName, String courseName, String checkInName){
        Integer result = 0;
        String sql1 = SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL8 + classGradesName + courseName +
                SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL10 + checkInName +
                SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL12;
        try {
            result = jdbcTemplate.queryForObject(sql1, Integer.class);
        } catch (DataAccessException e) {
            return -1;
        }
        return result;
    }

    private List<String> getNotCheckInList(String classGradesName, String courseName, String checkInName){
        String sql1 = SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL13 + classGradesName + courseName +
                SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL10 + checkInName +
                SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL12;
        List<String> list = jdbcTemplate.query(sql1, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("student_name");
            }
        });
        return list;
    }
}
