package com.hyh.servlet;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyh.pojo.Student;
import com.hyh.service.StudentService;
import com.hyh.utils.UtilXml;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 潮7000
 * @vesion 1.0
 * @date 2022/5/14 16:19
 */
@WebServlet("/list")
public class StudenListServlet extends HttpServlet {
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object user = req.getSession().getAttribute("user");


        if (user != null){
            StudentService studentService = UtilXml.getBeanConfig(StudentService.class);
            String pageNum = req.getParameter("pageNum");
            int num = 0;
            if (pageNum == null){
                num =1;
            }else {
                num = Integer.parseInt(pageNum);
            }
            PageHelper.startPage(num,6);
            List<Student> students = studentService.selectAllStudent();
            PageInfo<Student> pageInfo = new PageInfo(students);
            req.getSession().setAttribute("pageInfo",pageInfo);
            req.getRequestDispatcher("list.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
