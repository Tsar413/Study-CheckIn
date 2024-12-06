package com.study.checkIn.service.impl;

import com.study.checkIn.dto.CheckInURLDTO;
import com.study.checkIn.dto.StudentCheckInDTO;
import com.study.checkIn.service.IStudentCheckInService;
import com.study.checkIn.utils.DivideURL;
import com.study.checkIn.utils.SQLConstants;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class StudentCheckInServiceImpl implements IStudentCheckInService {
    private final JdbcTemplate jdbcTemplate;

    public StudentCheckInServiceImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

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

    @Override
    public String studentCheckInCheckIn(String major, String courseName, String checkInName, String studentName, String studentId) {
        String sql1 = SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL1 + major + courseName +
                SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL2 + studentId +
                SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL3 + studentName +
                SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL4;
        Integer result = 0;
        try {
            result = jdbcTemplate.queryForObject(sql1, Integer.class);
        } catch (DataAccessException e) {
            return "-1";
        }
        if(result == null){
            return "-1";
        }
        String sql2 = SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL5 + major + courseName +
                SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL6 + checkInName +
                SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL7 + studentId +
                SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL3 + studentName +
                SQLConstants.CHECK_CHECK_IN_STUDENTS_SQL4;
        try {
            jdbcTemplate.execute(sql2);
        } catch (DataAccessException e) {
            return "0";
        }
        return "1";
    }

}
