package com.hyh.dao;

import com.hyh.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 潮7000
 * @vesion 1.0
 * @date 2022/5/14 16:22
 */
public interface StudentDao {

    @Select("select * from student")
    List<Student> selectAllStudent();

    @Delete("delete from student where id = #{id}")
    int deleteStudentById(int id);

    @Insert("insert into student(name,gender,age,address,qq,email) values(#{name},#{gender},#{age},#{address},#{qq},#{email})")
    int insertStudent(Student student);

    @Delete("update student set name=#{name},gender=#{gender},age=#{age},address=#{address},qq=#{qq},email=#{email} where id = #{id}")
    int updateStudentById(Student student);

    @Select("select * from student where id=${id}")
    Student selectStudentById(int id);

    @Select("select * from student where 1=1 ${sql}")
    List<Student> searchBox(String sql);

}
