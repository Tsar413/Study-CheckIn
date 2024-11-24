package com.study.checkIn.mapper;

import com.study.checkIn.entity.ClassesGrades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassesGradesServiceMapper extends JpaRepository<ClassesGrades, Integer> {
    @Query(value = "select MAX(id) from classes_grades", nativeQuery = true)
    Integer findBiggestClassesGradesId();

    @Query(value = "select class_id from classes_grades where class_id = ?1", nativeQuery = true)
    Integer findByClassGradesId(Integer classGradesId);

    @Query(value = "select class_id from classes_grades where major = ?1", nativeQuery = true)
    Integer findByMajor(String major);

    @Query(value = "select * from classes_grades where major like %?1%", nativeQuery = true)
    List<ClassesGrades> findByClassGradesName(String classGradesName);
}
