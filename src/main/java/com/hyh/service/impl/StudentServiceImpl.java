package com.hyh.service.impl;

import com.hyh.dao.StudentDao;
import com.hyh.pojo.Student;
import com.hyh.service.StudentService;

import java.util.List;

/**
 * @author 潮7000
 * @vesion 1.0
 * @date 2022/5/14 16:26
 */
public class StudentServiceImpl implements StudentService{
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @Override
    public List<Student> selectAllStudent() {
        return studentDao.selectAllStudent();
    }

    @Override
    public int deleteStudentById(int id) {
        return studentDao.deleteStudentById(id);
    }

    @Override
    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public int updateStudentById(Student student) {
        return studentDao.updateStudentById(student);
    }

    @Override
    public Student selectStudentById(int id) {
        return studentDao.selectStudentById(id);
    }

    @Override
    public List<Student> searchBox(String sql) {
        return studentDao.searchBox(sql);
    }
}
