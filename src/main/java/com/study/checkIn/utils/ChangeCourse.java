package com.study.checkIn.utils;

import com.study.checkIn.dto.StudentDTO;
import com.study.checkIn.entity.Course;
import com.study.checkIn.mapper.ClassesGradesServiceMapper;
import com.study.checkIn.mapper.CourseServiceMapper;
import com.study.checkIn.mapper.UserServiceMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class ChangeCourse {
    private final JdbcTemplate jdbcTemplate;

    public ChangeCourse(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Resource
    private CourseServiceMapper courseServiceMapper;

    @Resource
    private ClassesGradesServiceMapper classesGradesServiceMapper;

    public Integer changeCourseTime(Course courseData, Course newCourse){
        return courseServiceMapper.changeCourseTime(newCourse.getId(), newCourse.getCourseId(), newCourse.getCourseTime());
    }

    public Integer changeTeacherId(Course courseData, Course newCourse){
        return courseServiceMapper.changeTeacherId(newCourse.getId(), newCourse.getCourseId(), newCourse.getTeacherId());
    }

    public Integer changeCourseName(Course courseData, Course newCourse){
        String majorOld = classesGradesServiceMapper.findByClassGradesName(String.valueOf(courseData.getClassId())).get(0).getMajor();
        String majorNew = classesGradesServiceMapper.findByClassGradesName(String.valueOf(newCourse.getClassId())).get(0).getMajor();
        System.out.println(majorOld + courseData.getCourseName());
        System.out.println(majorNew + newCourse.getCourseName());
        int flag = 0;
        String sql1 = SQLConstants.CHANGE_TABLE_NAME1 + majorOld + courseData.getCourseName() +
                SQLConstants.CHANGE_TABLE_NAME2 + majorNew + newCourse.getCourseName() +
                SQLConstants.CHANGE_TABLE_NAME3;
        try {
            flag = courseServiceMapper.changeCourseAndClass(newCourse.getId(), newCourse.getCourseId(), newCourse.getClassId(), newCourse.getCourseName());
        } catch (Exception e) {
            return 0;
        }
        if(flag == 1){
            try {
                jdbcTemplate.execute(sql1);
            } catch (Exception e){
                return 0;
            }
            return 1;
        }
        return 0;
    }

    public Integer changeClassGrades(Course courseData, Course newCourse){
        String majorOld = classesGradesServiceMapper.findByClassGradesName(String.valueOf(courseData.getClassId())).get(0).getMajor();
        String majorNew = classesGradesServiceMapper.findByClassGradesName(String.valueOf(newCourse.getClassId())).get(0).getMajor();
        System.out.println(majorOld + courseData.getCourseName());
        System.out.println(majorNew + newCourse.getCourseName());
        String sql1 = SQLConstants.DROP_TABLE1 + majorOld + courseData.getCourseName() + SQLConstants.DROP_TABLE2;
        try {
            courseServiceMapper.changeCourseAndClass(newCourse.getId(), newCourse.getCourseId(), newCourse.getClassId(), newCourse.getCourseName());
            jdbcTemplate.execute(sql1);
            StringBuilder sql = new StringBuilder("CREATE TABLE `");
            sql.append(majorNew).append(newCourse.getCourseName()).append("` (");
            sql.append("id INT Primary Key,").append("student_id INT,")
                    .append("student_name varchar(20));");
            jdbcTemplate.execute(sql.toString());
            List<StudentDTO> list = copyStudentToCourseTables(majorNew);
            for (StudentDTO studentDTO : list){
                StringBuilder sql2 = new StringBuilder("INSERT INTO `");
                sql2.append(majorNew).append(newCourse.getCourseName()).append("` values (");
                sql2.append(getBiggestStudentTableId(majorNew + newCourse.getCourseName())).append(",");
                sql2.append(studentDTO.getStudentId()).append(", '");
                sql2.append(studentDTO.getStudentName()).append("');");
                jdbcTemplate.execute(sql2.toString());
            }
        } catch (Exception e){
            return 0;
        }
        return 1;
    }

    private Integer getBiggestStudentTableId(String studentTableName){
        StringBuilder sql = new StringBuilder("select max(id) from `");
        sql.append(studentTableName).append("`;");
        Integer result = jdbcTemplate.queryForObject(sql.toString(), Integer.class);
        if(result == null){
            return 0;
        }
        return result + 1;
    }

    private List<StudentDTO> copyStudentToCourseTables(String classGradesName){
        StringBuilder sql1 = new StringBuilder("select * from `" + classGradesName + "student`;");
        List<StudentDTO> list = jdbcTemplate.query(sql1.toString(), new RowMapper<StudentDTO>() {
            @Override
            public StudentDTO mapRow(ResultSet resultSet, int i) throws SQLException {
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setId(Integer.valueOf(resultSet.getString("id")));
                studentDTO.setStudentId(Integer.valueOf(resultSet.getString("student_id")));
                studentDTO.setStudentName(resultSet.getString("student_name"));
                return studentDTO;
            }
        });
        System.out.println(list);
        return list;
    }
}
