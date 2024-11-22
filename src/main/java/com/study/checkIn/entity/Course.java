package com.study.checkIn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer courseId;

    private String courseName;

    private Integer teacherId;

    private Integer classId;

    private String courseTime;

    public Course() {
    }

    public Course(Integer id, Integer courseId, String courseName, Integer teacherId, Integer classId, String courseTime) {
        this.id = id;
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherId = teacherId;
        this.classId = classId;
        this.courseTime = courseTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", teacherId=" + teacherId +
                ", classId=" + classId +
                ", courseTime='" + courseTime + '\'' +
                '}';
    }
}
