package com.study.checkIn.dto;

import java.util.List;

public class CheckInResultDTO {
    private String teacherName;

    private String courseName;

    private String classGradesName;

    private String checkInName;

    private Integer studentNumber;

    private Integer checkInNumber;

    private Integer notCheckInNumber;

    private List<StudentDTO> notCheckInStudentList;

    public CheckInResultDTO() {
    }

    public CheckInResultDTO(String teacherName, String courseName, String classGradesName, String checkInName, Integer studentNumber, Integer checkInNumber, Integer notCheckInNumber, List<StudentDTO> notCheckInStudentList) {
        this.teacherName = teacherName;
        this.courseName = courseName;
        this.classGradesName = classGradesName;
        this.checkInName = checkInName;
        this.studentNumber = studentNumber;
        this.checkInNumber = checkInNumber;
        this.notCheckInNumber = notCheckInNumber;
        this.notCheckInStudentList = notCheckInStudentList;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassGradesName() {
        return classGradesName;
    }

    public void setClassGradesName(String classGradesName) {
        this.classGradesName = classGradesName;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Integer getCheckInNumber() {
        return checkInNumber;
    }

    public void setCheckInNumber(Integer checkInNumber) {
        this.checkInNumber = checkInNumber;
    }

    public Integer getNotCheckInNumber() {
        return notCheckInNumber;
    }

    public void setNotCheckInNumber(Integer notCheckInNumber) {
        this.notCheckInNumber = notCheckInNumber;
    }

    public List<StudentDTO> getNotCheckInStudentList() {
        return notCheckInStudentList;
    }

    public void setNotCheckInStudentList(List<StudentDTO> notCheckInStudentList) {
        this.notCheckInStudentList = notCheckInStudentList;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCheckInName() {
        return checkInName;
    }

    public void setCheckInName(String checkInName) {
        this.checkInName = checkInName;
    }

    @Override
    public String toString() {
        return "CheckInResultDTO{" +
                "teacherName='" + teacherName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", classGradesName='" + classGradesName + '\'' +
                ", checkInName='" + checkInName + '\'' +
                ", studentNumber=" + studentNumber +
                ", checkInNumber=" + checkInNumber +
                ", notCheckInNumber=" + notCheckInNumber +
                ", notCheckInStudentList=" + notCheckInStudentList +
                '}';
    }
}
