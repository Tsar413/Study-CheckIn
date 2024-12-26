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

    private Integer isCancelled;

    private Integer isFinished;

    public Course() {
    }

    public Course(Integer id, Integer courseId, String courseName, Integer teacherId, Integer classId, String courseTime, Integer isCancelled, Integer isFinished) {
        this.id = id;
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherId = teacherId;
        this.classId = classId;
        this.courseTime = courseTime;
        this.isCancelled = isCancelled;
        this.isFinished = isFinished;
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

    public Integer getIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(Integer isCancelled) {
        this.isCancelled = isCancelled;
    }

    public Integer getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Integer isFinished) {
        this.isFinished = isFinished;
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
                ", isCancelled=" + isCancelled +
                ", isFinished=" + isFinished +
                '}';
    }
}
