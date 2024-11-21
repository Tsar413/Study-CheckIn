package com.study.checkIn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClassesGrades {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer classId;

    private String major;

    private Integer studentNumber;

    public ClassesGrades() {
    }

    public ClassesGrades(Integer id, Integer classId, String major, Integer studentNumber) {
        this.id = id;
        this.classId = classId;
        this.major = major;
        this.studentNumber = studentNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "ClassesGrades{" +
                "id=" + id +
                ", classId=" + classId +
                ", major='" + major + '\'' +
                ", studentNumber=" + studentNumber +
                '}';
    }
}
