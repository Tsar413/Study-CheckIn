package com.study.checkIn.mapper;

import com.study.checkIn.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CourseServiceMapper  extends JpaRepository<Course, Integer> {
    @Query(value = "select MAX(id) from Course", nativeQuery = true)
    Integer findBiggestId();

    @Query(value = "select MAX(course_id) from Course", nativeQuery = true)
    Integer findBiggestCourseId();

    @Query(value = "select * from Course where class_id = ?1", nativeQuery = true)
    List<Course> findByClassId(int classId);

    @Query(value = "select * from Course where is_cancelled IS NULL && is_finished IS NULL", nativeQuery = true)
    List<Course> findAllCourses();

    @Query(value = "select * from Course where is_cancelled = 1 || is_finished = 1", nativeQuery = true)
    List<Course> findNotAvailableCourses();

    @Query(value = "select * from course where teacher_id = ?1", nativeQuery = true)
    List<Course> findByTeacherId(Integer teacherId);

    @Query(value = "select * from course where teacher_id = ?1 && course_name = ?2", nativeQuery = true)
    List<Course> findByTeacherIdCourses(Integer teacherId, String courseName);

    @Query(value = "select * from course where id = ?1 && course_id = ?2", nativeQuery = true)
    List<Course> findByCourseId(Integer id, Integer courseId);

    @Query(value = "update Course set course_time = ?3 where id = ?1 && course_id = ?2", nativeQuery = true)
    @Transactional
    @Modifying
    Integer changeCourseTime(Integer id, Integer courseId, String courseTime);

    @Query(value = "update Course set teacher_id = ?3 where id = ?1 && course_id = ?2", nativeQuery = true)
    @Transactional
    @Modifying
    Integer changeTeacherId(Integer id, Integer courseId, Integer teacherId);

    @Query(value = "update Course set class_id = ?3, course_name = ?4 where id = ?1 && course_id = ?2", nativeQuery = true)
    @Transactional
    @Modifying
    Integer changeCourseAndClass(Integer id, Integer courseId, Integer classId, String courseName);

    @Query(value = "update Course set is_cancelled = 1 where id = ?1 && course_id = ?2", nativeQuery = true)
    @Transactional
    @Modifying
    Integer deleteCourse(Integer id, Integer courseId);
}
