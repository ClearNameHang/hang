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
 * @date 2022/5/14 16:44
 */
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        Student student = new Student();
        Map<String, String[]> map = req.getParameterMap();

        // 统一用一个工具类  BeanUtils.populate()把map集合封装到student中
        try {
            BeanUtils.populate(student,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        StudentService studentService = UtilXml.getBeanConfig(StudentService.class);
        int i = studentService.insertStudent(student);
        if (i == 1){
            resp.sendRedirect("list");
        }else{
            req.getRequestDispatcher("add.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
