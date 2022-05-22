package com.hyh.servlet;

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
 * @date 2022/5/14 22:22
 */
@WebServlet("/batchDelete")
public class BatchDeleteStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService studentService = UtilXml.getBeanConfig(StudentService.class);
        String[] ids = req.getParameterValues("ids");
        for (String i:ids) {
            studentService.deleteStudentById(Integer.parseInt(i));
        }
        resp.sendRedirect("list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req, resp);
    }
}
