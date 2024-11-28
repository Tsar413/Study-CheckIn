package com.study.checkIn.dto;

public class CreateCheckInDTO {
    private String tableName;

    private String checkInName;

    public CreateCheckInDTO() {
    }

    public CreateCheckInDTO(String tableName, String checkInName) {
        this.tableName = tableName;
        this.checkInName = checkInName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getCheckInName() {
        return checkInName;
    }

    public void setCheckInName(String checkInName) {
        this.checkInName = checkInName;
    }

    @Override
    public String toString() {
        return "CreateCheckInDTO{" +
                "tableName='" + tableName + '\'' +
                ", checkInName='" + checkInName + '\'' +
                '}';
    }
}
