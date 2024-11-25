package com.study.checkIn.dto;

public class StudentDTO {
    private Integer id;

    private Integer studentId;

    private String studentName;

    private String studentClassGradesName;

    public StudentDTO() {
    }

    public StudentDTO(Integer id, Integer studentId, String studentName, String studentClassGradesName) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClassGradesName = studentClassGradesName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClassGradesName() {
        return studentClassGradesName;
    }

    public void setStudentClassGradesName(String studentClassGradesName) {
        this.studentClassGradesName = studentClassGradesName;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentClassGradesName='" + studentClassGradesName + '\'' +
                '}';
    }
}
