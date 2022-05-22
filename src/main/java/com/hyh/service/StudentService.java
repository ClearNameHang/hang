package com.hyh.service;

import com.hyh.pojo.Student;

import java.util.List;

/**
 * @author 潮7000
 * @vesion 1.0
 * @date 2022/5/14 16:25
 */
public interface StudentService {

    List<Student> selectAllStudent();

    int deleteStudentById(int id);

    int insertStudent(Student student);

    int updateStudentById(Student student);

    Student selectStudentById(int id);

    List<Student> searchBox(String sql);
}
