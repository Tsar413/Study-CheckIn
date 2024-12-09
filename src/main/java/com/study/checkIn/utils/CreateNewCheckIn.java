package com.study.checkIn.utils;

import com.study.checkIn.dto.CreateCheckInDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CreateNewCheckIn {
    private final JdbcTemplate jdbcTemplate;

    public CreateNewCheckIn(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer createNewCheckIn(CreateCheckInDTO createCheckInDTO){
        StringBuilder sql = new StringBuilder("ALTER TABLE `");
        sql.append(createCheckInDTO.getTableName()).append("` ADD `");
        sql.append(createCheckInDTO.getCheckInName()).append("` INT DEFAULT 0");
        try {
            jdbcTemplate.execute(sql.toString());
        } catch (Exception e){
            return 0;
        }
        return 1;
    }
}
