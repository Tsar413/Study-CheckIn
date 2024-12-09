package com.study.checkIn.utils;

import com.study.checkIn.entity.ClassesGrades;
import com.study.checkIn.entity.Course;
import com.study.checkIn.mapper.ClassesGradesServiceMapper;
import com.study.checkIn.mapper.CourseServiceMapper;
import com.study.checkIn.mapper.UserServiceMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GetStudyDetails {
    private final JdbcTemplate jdbcTemplate;

    public GetStudyDetails(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Resource
    private UserServiceMapper userServiceMapper;

    @Resource
    private CourseServiceMapper courseServiceMapper;

    @Resource
    private ClassesGradesServiceMapper classesGradesServiceMapper;

    public List<Course> getCourseNames(String teacherName){
        Integer userId = userServiceMapper.findBiggestUsername(teacherName);
        if(userId != null){
            List<Course> result = courseServiceMapper.findByTeacherId(userId);
            System.out.println(result);
            return result;
        }
        return null;
    }

    public List<ClassesGrades> getTeacherCourses(String teacherName, String courses){
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

    public List<String> getCheckIn(String classGradeName, String courses){
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
