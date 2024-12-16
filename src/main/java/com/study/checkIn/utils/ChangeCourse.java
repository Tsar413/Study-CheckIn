package com.study.checkIn.utils;

import com.study.checkIn.entity.Course;
import com.study.checkIn.mapper.ClassesGradesServiceMapper;
import com.study.checkIn.mapper.CourseServiceMapper;
import com.study.checkIn.mapper.UserServiceMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ChangeCourse {
    private final JdbcTemplate jdbcTemplate;

    public ChangeCourse(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Resource
    private CourseServiceMapper courseServiceMapper;

    @Resource
    private ClassesGradesServiceMapper classesGradesServiceMapper;

    public Integer changeCourseTime(Course courseData, Course newCourse){
        return courseServiceMapper.changeCourseTime(newCourse.getId(), newCourse.getCourseId(), newCourse.getCourseTime());
    }

    public Integer changeCourseName(Course courseData, Course newCourse){
        String major = classesGradesServiceMapper.findByClassGradesName(String.valueOf(courseData.getClassId())).get(0).getMajor();
        System.out.println(major + newCourse.getCourseName());
        return 0;
    }
}
