package com.study.checkIn.service.impl;

import com.study.checkIn.entity.ClassesGrades;
import com.study.checkIn.entity.Course;
import com.study.checkIn.entity.User;
import com.study.checkIn.mapper.ClassesGradesServiceMapper;
import com.study.checkIn.mapper.CourseServiceMapper;
import com.study.checkIn.mapper.UserServiceMapper;
import com.study.checkIn.service.IManagementService;
import com.study.checkIn.utils.ChangeCourse;
import com.study.checkIn.utils.GetStudyDetails;
import com.study.checkIn.utils.SQLConstants;
import com.study.checkIn.utils.URLConstants;
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

    @Resource
    private UserServiceMapper userServiceMapper;

    @Resource
    private CourseServiceMapper courseServiceMapper;

    @Resource
    private ClassesGradesServiceMapper classesGradesServiceMapper;

    @Resource
    private GetStudyDetails getStudyDetails;

    @Resource
    private ChangeCourse changeCourse;

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
        return getStudyDetails.getCourseNames(teacherName);
    }

    @Override
    public List<ClassesGrades> managementCheckTeacherCourses(String teacherName, String courses) {
        return getStudyDetails.getTeacherCourses(teacherName, courses);
    }

    @Override
    public List<String> managementCheckCheckIn(String classGradeName, String courses) {
        return getStudyDetails.getCheckIn(classGradeName, courses);
    }

    @Override
    public String managementGetCheckInURL(String classGradesName, String courses, String checkInName) {
        String result = URLConstants.URL1 + URLConstants.URL2 + classGradesName + URLConstants.URL3 +
                courses + URLConstants.URL4 + checkInName;
        return result;
    }

    @Override
    public String managementChangeTeacherName(String oldTeacherName, String newTeacherName) {
        try {
            userServiceMapper.changeTeacherName(oldTeacherName, newTeacherName);
        } catch (Exception e){
            return "-1";
        }
        return "1";
    }

    @Override
    public Course managementChangeCourse(String id, String courseId, String courseName, String classId, String teacherId, String courseTime) {
        Course courseData = courseServiceMapper.findByCourseId(Integer.parseInt(id), Integer.parseInt(courseId)).get(0);
        Course course = new Course();
        course.setId(Integer.parseInt(id));
        course.setCourseId(Integer.parseInt(courseId));
        course.setCourseName(courseName);
        course.setClassId(Integer.parseInt(classId));
        course.setTeacherId(Integer.parseInt(teacherId));
        course.setCourseTime(courseTime);
        int flag = checkChangeCourse(courseData, course);
        if(flag == 0){
            return null;
        }
        return course;
    }

    private Integer checkChangeCourse(Course courseData, Course newCourse){
        if(!courseData.getCourseTime().equals(newCourse.getCourseTime())){
            try {
                changeCourse.changeCourseTime(courseData, newCourse);
            } catch (Exception e){
                return 0;
            }
        }
        if(!courseData.getCourseName().equals(newCourse.getCourseName())){
            changeCourse.changeCourseName(courseData, newCourse);
        }
        return 1;
    }
}
