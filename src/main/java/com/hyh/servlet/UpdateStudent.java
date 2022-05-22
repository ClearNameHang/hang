package com.hyh.servlet;

import com.hyh.pojo.Student;
import com.hyh.service.StudentService;
import com.hyh.utils.UtilXml;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author 潮7000
 * @vesion 1.0
 * @date 2022/5/14 20:44
 */
@WebServlet("/updateStudent")
public class UpdateStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StudentService studentService = UtilXml.getBeanConfig(StudentService.class);
        Student student = new Student();
        Map<String,String[]> parameterMap = req.getParameterMap();

        try {
            BeanUtils.populate(student,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        int i = studentService.updateStudentById(student);
        if(i == 1){
            resp.sendRedirect("list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
