package com.study.checkIn.mapper;

import com.study.checkIn.entity.ClassesGrades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClassesGradesServiceMapper extends JpaRepository<ClassesGrades, Integer> {
    @Query(value = "select MAX(id) from classes_grades", nativeQuery = true)
    Integer findBiggestClassesGradesId();
}
