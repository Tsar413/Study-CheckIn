package com.study.checkIn.service.impl;

import com.study.checkIn.entity.ClassesGrades;
import com.study.checkIn.entity.Course;
import com.study.checkIn.entity.User;
import com.study.checkIn.mapper.ClassesGradesServiceMapper;
import com.study.checkIn.mapper.CourseServiceMapper;
import com.study.checkIn.mapper.UserServiceMapper;
import com.study.checkIn.service.IManagementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.List;

@Service
public class ManagementServiceImpl implements IManagementService {
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
}
