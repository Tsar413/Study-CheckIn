package com.study.checkIn.mapper;

import com.study.checkIn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserServiceMapper extends JpaRepository<User, Integer> {
    @Query(value = "select MAX(user_id) from User", nativeQuery = true)
    Integer findBiggestUserId();

    @Query(value = "select user_id from User where username = ?1", nativeQuery = true)
    Integer findBiggestUsername(String username);

    @Query(value = "select * from User where privilege = 2 && username like %?1%", nativeQuery = true)
    List<User> findByDiffUsername(String username);

    @Query(value = "select * from User", nativeQuery = true)
    List<User> findAllUsers();

    @Query(value = "update User set user.username = ?2 where user.username = ?1", nativeQuery = true)
    @Transactional
    @Modifying
    Integer changeTeacherName(String oldTeacherName, String newTeacherName);
}
