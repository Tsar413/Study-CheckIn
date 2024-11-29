package com.study.checkIn.mapper;

import com.study.checkIn.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseServiceMapper  extends JpaRepository<Course, Integer> {
    @Query(value = "select MAX(id) from Course", nativeQuery = true)
    Integer findBiggestId();

    @Query(value = "select MAX(course_id) from Course", nativeQuery = true)
    Integer findBiggestCourseId();

    @Query(value = "select * from Course where class_id = ?1", nativeQuery = true)
    List<Course> findByClassId(int classId);

    @Query(value = "select * from Course", nativeQuery = true)
    List<Course> findAllCourses();
}
