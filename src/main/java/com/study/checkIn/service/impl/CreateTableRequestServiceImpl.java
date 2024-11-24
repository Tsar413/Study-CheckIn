package com.study.checkIn.service.impl;

import com.study.checkIn.service.ICreateTableRequestService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreateTableRequestServiceImpl implements ICreateTableRequestService {
    private final JdbcTemplate jdbcTemplate;

    public CreateTableRequestServiceImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer managementAddCreateTableRequest1(String tableName) {
        StringBuilder sql = new StringBuilder("CREATE TABLE ");
        sql.append(tableName).append(" (");
        sql.append("id INT Primary Key,").append("student_id INT,")
                .append("student_name varchar(20));");
        jdbcTemplate.execute(sql.toString());
        return 1;
    }
}
