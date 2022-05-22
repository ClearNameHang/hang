package com.hyh.servlet;

import com.hyh.pojo.Student;
import com.hyh.service.StudentService;
import com.hyh.utils.UtilXml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 潮7000
 * @vesion 1.0
 * @date 2022/5/14 20:58
 */
@WebServlet("/selectById")
public class SelectStudentById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        StudentService studentService = UtilXml.getBeanConfig(StudentService.class);
        Student student = studentService.selectStudentById(Integer.parseInt(id));
        if (student != null){
            req.getSession().setAttribute("student",student);
            req.getRequestDispatcher("update.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
