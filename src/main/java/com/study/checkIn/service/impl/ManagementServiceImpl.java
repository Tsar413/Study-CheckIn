package com.study.checkIn.service.impl;

import com.study.checkIn.dto.StudentDTO;
import com.study.checkIn.entity.ClassesGrades;
import com.study.checkIn.entity.Course;
import com.study.checkIn.entity.User;
import com.study.checkIn.mapper.ClassesGradesServiceMapper;
import com.study.checkIn.mapper.CourseServiceMapper;
import com.study.checkIn.mapper.UserServiceMapper;
import com.study.checkIn.service.IManagementService;
import com.study.checkIn.utils.SQLConstants;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManagementServiceImpl implements IManagementService {
    private final JdbcTemplate jdbcTemplate;

    public ManagementServiceImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Resource
    private UserServiceMapper userServiceMapper;

    @Resource
    private CourseServiceMapper courseServiceMapper;

    @Resource
    private ClassesGradesServiceMapper classesGradesServiceMapper;

    @Override
    public List<User> managementGetAllUsers() {
        return userServiceMapper.findAllUsers();
    }

    @Override
    public List<Course> managementGetAllCourses() {
        return courseServiceMapper.findAllCourses();
    }

    @Override
    public List<ClassesGrades> managementGetAllClassesGrades() {
        return classesGradesServiceMapper.findAllClassGrades();
    }

    @Override
    public List<Course> managementCheckCourseNames(String teacherName) {
        Integer userId = userServiceMapper.findBiggestUsername(teacherName);
        if(userId != null){
            List<Course> result = courseServiceMapper.findByTeacherId(userId);
            System.out.println(result);
            return result;
        }
        return null;
    }

    @Override
    public List<ClassesGrades> managementCheckTeacherCourses(String teacherName, String courses) {
        Integer userId = userServiceMapper.findBiggestUsername(teacherName);
        List<ClassesGrades> list = new ArrayList<ClassesGrades>();
        if(userId != null){
            List<Course> courseList = courseServiceMapper.findByTeacherIdCourses(userId, courses);
            System.out.println(courseList);
            for (Course c : courseList){
                list.addAll(classesGradesServiceMapper.findByClassId(c.getClassId()));
            }
        }
        return list;
    }

    @Override
    public List<String> managementCheckCheckIn(String classGradeName, String courses) {
        String sql = SQLConstants.GET_CHECK_IN_COLUMN_SQL1 + classGradeName +
                courses + SQLConstants.GET_CHECK_IN_COLUMN_SQL2;
        List<String> list = jdbcTemplate.query(sql, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("COLUMN_NAME");
            }
        });
        System.out.println(list);
        return list;
    }
}
