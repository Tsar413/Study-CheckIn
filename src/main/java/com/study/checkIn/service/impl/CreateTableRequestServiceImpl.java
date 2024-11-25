package com.study.checkIn.service.impl;

import com.study.checkIn.dto.StudentDTO;
import com.study.checkIn.service.ICreateTableRequestService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    @Override
    public Integer managementAddAddStudent(StudentDTO studentDTO) {
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(studentDTO.getStudentClassGradesName()).append(" values (");
        sql.append(getBiggestStudentTableId(studentDTO.getStudentClassGradesName())).append(",");
        sql.append(studentDTO.getStudentId()).append(", '");
        sql.append(studentDTO.getStudentName()).append("');");
        jdbcTemplate.execute(sql.toString());
        return 1;
    }

    private Integer getBiggestStudentTableId(String studentTableName){
        StringBuilder sql = new StringBuilder("select max(id) from ");
        sql.append(studentTableName).append(";");
        Integer result = jdbcTemplate.queryForObject(sql.toString(), Integer.class);
        if(result == null){
            return 0;
        }
        return result + 1;
    }

//    StringBuilder sql1 = new StringBuilder("select * from " + studentTableName + ";");
//    List<StudentDTO> list = jdbcTemplate.query(sql1.toString(), new RowMapper<StudentDTO>() {
//        @Override
//        public StudentDTO mapRow(ResultSet resultSet, int i) throws SQLException {
//            StudentDTO studentDTO = new StudentDTO();
//            studentDTO.setId(Integer.valueOf(resultSet.getString("id")));
//            studentDTO.setStudentId(Integer.valueOf(resultSet.getString("student_id")));
//            studentDTO.setStudentName(resultSet.getString("student_name"));
//            return studentDTO;
//        }
//    });
//        System.out.println(list);
}
