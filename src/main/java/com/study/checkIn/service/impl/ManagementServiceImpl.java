package com.study.checkIn.service.impl;

import com.study.checkIn.entity.ClassesGrades;
import com.study.checkIn.entity.User;
import com.study.checkIn.mapper.ClassesGradesServiceMapper;
import com.study.checkIn.mapper.ManagementServiceMapper;
import com.study.checkIn.service.IManagementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ManagementServiceImpl implements IManagementService {
    @Resource
    private ManagementServiceMapper managementServiceMapper;

    @Resource
    private ClassesGradesServiceMapper classesGradesServiceMapper;

    @Override
    public User managementAddUserTest(String username, String password, String privilege) {
        User user = new User();
        user.setUserId(1);
        user.setUsername(username);
        user.setPassword(password);
        if(privilege.equals("Admin")){
            user.setPrivilege(1);
        } else if(privilege.equals("Teacher")){
            user.setPrivilege(2);
        }
        return user;
    }

    @Override
    public String managementAddUser(String username, String password, String privilege) {
        User user = new User();
        user.setUserId(0);
        if (managementServiceMapper.findBiggestUserId() != null){
            user.setUserId(managementServiceMapper.findBiggestUserId() + 1);
        }
        user.setUsername(username);
        user.setPassword(password);
        if(privilege.equals("Admin")){
            user.setPrivilege(1);
        } else if(privilege.equals("Teacher")){
            user.setPrivilege(2);
        }
        System.out.println(user);
        managementServiceMapper.save(user);
        return "1";
    }

    @Override
    public ClassesGrades managementAddClassTest(String classId, String major, String studentNumber) {
        ClassesGrades classesGrades = new ClassesGrades();
        classesGrades.setId(0);
        if(classesGradesServiceMapper.findBiggestClassesGradesId() != null){
            classesGrades.setId(classesGradesServiceMapper.findBiggestClassesGradesId() + 1);
        }
        classesGrades.setClassId(Integer.parseInt(classId));
        classesGrades.setMajor(major);
        classesGrades.setStudentNumber(Integer.parseInt(studentNumber));
        System.out.println(classesGrades);
        return classesGrades;
    }
}
