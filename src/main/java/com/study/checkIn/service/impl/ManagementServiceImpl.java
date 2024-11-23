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
import java.util.List;

@Service
public class ManagementServiceImpl implements IManagementService {
    @Resource
    private UserServiceMapper userServiceMapper;

    @Resource
    private ClassesGradesServiceMapper classesGradesServiceMapper;

    @Resource
    private CourseServiceMapper courseServiceMapper;

    @Override
    public User managementAddUserTest(String username, String password, String privilege) {
        User user = new User();
        user.setUserId(1);
        user.setUsername(username);
        user.setPassword(password);
        if(privilege.equals("Admin")){
            user.setPrivilege(1);
        } else if(privilege.equals("Teacher")){
            user.setPrivilege(2);
        }
        return user;
    }

    @Override
    public String managementAddUser(String username, String password, String privilege) {
        User user = new User();
        user.setUserId(0);
        if (userServiceMapper.findBiggestUserId() != null){
            user.setUserId(userServiceMapper.findBiggestUserId() + 1);
        }
        user.setUsername(username);
        user.setPassword(password);
        if(privilege.equals("Admin")){
            user.setPrivilege(1);
        } else if(privilege.equals("Teacher")){
            user.setPrivilege(2);
        }
        System.out.println(user);
        userServiceMapper.save(user);
        return "1";
    }

    @Override
    public ClassesGrades managementAddClassTest(String classId, String major, String studentNumber) {
        ClassesGrades classesGrades = new ClassesGrades();
        classesGrades.setId(0);
        if(classesGradesServiceMapper.findBiggestClassesGradesId() != null){
            classesGrades.setId(classesGradesServiceMapper.findBiggestClassesGradesId() + 1);
        }
        classesGrades.setClassId(Integer.parseInt(classId));
        classesGrades.setMajor(major);
        classesGrades.setStudentNumber(Integer.parseInt(studentNumber));
        System.out.println(classesGrades);
        return classesGrades;
    }

    @Override
    public String managementAddClass(String classId, String major, String studentNumber) {
        ClassesGrades classesGrades = new ClassesGrades();
        classesGrades.setId(0);
        if(classesGradesServiceMapper.findBiggestClassesGradesId() != null){
            classesGrades.setId(classesGradesServiceMapper.findBiggestClassesGradesId() + 1);
        }
        classesGrades.setClassId(Integer.parseInt(classId));
        classesGrades.setMajor(major);
        classesGrades.setStudentNumber(Integer.parseInt(studentNumber));
        System.out.println(classesGrades);
        if(classesGradesServiceMapper.findByClassGradesId(Integer.parseInt(classId)) != null){
            return "0";
        }
        classesGradesServiceMapper.save(classesGrades);
        return "1";
    }

    @Override
    public Course managementAddCourseTest(String courseName, String classGradesName, String teacherName, String courseTime) {
        Course course = new Course();
        course.setId(0);
        if(courseServiceMapper.findBiggestId() != null){
            course.setId(courseServiceMapper.findBiggestId() + 1);
        }
        course.setCourseId(0);
        if(courseServiceMapper.findBiggestCourseId() != null){
            course.setCourseId(courseServiceMapper.findBiggestCourseId() + 1);
        }
        course.setCourseName(courseName);
        if(userServiceMapper.findBiggestUsername(teacherName) == null){
            return null;
        }
        course.setTeacherId(userServiceMapper.findBiggestUsername(teacherName));
        if(classesGradesServiceMapper.findByMajor(classGradesName) == null){
            return null;
        }
        course.setClassId(classesGradesServiceMapper.findByMajor(classGradesName));
        course.setCourseTime(courseTime);
        System.out.println(course);
        return course;
    }

    @Override
    public String managementAddCourse(String courseName, String classGradesName, String teacherName, String courseTime) {
        Course course = new Course();
        course.setId(0);
        if(courseServiceMapper.findBiggestId() != null){
            course.setId(courseServiceMapper.findBiggestId() + 1);
        }
        course.setCourseId(0);
        if(courseServiceMapper.findBiggestCourseId() != null){
            course.setCourseId(courseServiceMapper.findBiggestCourseId() + 1);
        }
        course.setCourseName(courseName);
        if(userServiceMapper.findBiggestUsername(teacherName) == null){
            return "-1";
        }
        course.setTeacherId(userServiceMapper.findBiggestUsername(teacherName));
        if(classesGradesServiceMapper.findByMajor(classGradesName) == null){
            return "-1";
        }
        course.setClassId(classesGradesServiceMapper.findByMajor(classGradesName));
        course.setCourseTime(courseTime);
        System.out.println(course);
        courseServiceMapper.save(course);
        return "1";
    }

    @Override
    public List<User> managementAddCheckTeacher(String teacherName) {
        return userServiceMapper.findByDiffUsername(teacherName);
    }
}
