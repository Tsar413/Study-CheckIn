package com.study.checkIn.dto;

public class StudentCheckInDTO {
    private String major;

    private String courseName;

    private String checkInName;

    private String studentName;

    private Integer studentId;

    public StudentCheckInDTO() {
    }

    public StudentCheckInDTO(String major, String courseName, String checkInName, String studentName, Integer studentId) {
        this.major = major;
        this.courseName = courseName;
        this.checkInName = checkInName;
        this.studentName = studentName;
        this.studentId = studentId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCheckInName() {
        return checkInName;
    }

    public void setCheckInName(String checkInName) {
        this.checkInName = checkInName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "StudentCheckInDTO{" +
                "major='" + major + '\'' +
                ", courseName='" + courseName + '\'' +
                ", checkInName='" + checkInName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}
