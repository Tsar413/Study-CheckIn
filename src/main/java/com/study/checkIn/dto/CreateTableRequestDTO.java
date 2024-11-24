package com.study.checkIn.dto;

import java.util.List;

public class CreateTableRequestDTO {
    private String tableName;
    private List<ColumnDefinition> columns;

    public static class ColumnDefinition {
        private String name;
        private String type;
        private boolean nullable;
        private boolean primaryKey;

        public ColumnDefinition() {
        }

        public ColumnDefinition(String name, String type, boolean nullable, boolean primaryKey) {
            this.name = name;
            this.type = type;
            this.nullable = nullable;
            this.primaryKey = primaryKey;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isNullable() {
            return nullable;
        }

        public void setNullable(boolean nullable) {
            this.nullable = nullable;
        }

        public boolean isPrimaryKey() {
            return primaryKey;
        }

        public void setPrimaryKey(boolean primaryKey) {
            this.primaryKey = primaryKey;
        }

        @Override
        public String toString() {
            return "ColumnDefinition{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", nullable=" + nullable +
                    ", primaryKey=" + primaryKey +
                    '}';
        }
    }

    public CreateTableRequestDTO() {
    }

    public CreateTableRequestDTO(String tableName, List<ColumnDefinition> columns) {
        this.tableName = tableName;
        this.columns = columns;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnDefinition> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnDefinition> columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "CreateTableRequestDTO{" +
                "tableName='" + tableName + '\'' +
                ", columns=" + columns +
                '}';
    }
}
