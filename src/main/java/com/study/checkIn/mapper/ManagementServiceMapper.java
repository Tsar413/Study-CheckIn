package com.study.checkIn.mapper;

import com.study.checkIn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ManagementServiceMapper extends JpaRepository<User, Integer> {
    @Query(value = "select MAX(user_id) from User", nativeQuery = true)
    Integer findBiggestUserId();

    @Query(value = "select user_id from User where username = ?1", nativeQuery = true)
    Integer findBiggestUsername(String username);
}
