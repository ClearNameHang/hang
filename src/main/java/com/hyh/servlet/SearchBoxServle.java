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
import java.util.Map;
import java.util.Set;

/**
 * @author 潮7000
 * @vesion 1.0
 * @date 2022/5/15 10:55
 */
@WebServlet("/searchBox")
public class SearchBoxServle extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String[]> parameterMap = req.getParameterMap();
        req.setAttribute("queryCondition",parameterMap);
        StringBuilder sql =new StringBuilder();
        //获取所有的键
        Set<String> strings = parameterMap.keySet();
        for(String key : strings){
            //键的值value
            String value = parameterMap.get(key)[0];
            //如果不为空加入查询条件
            if (value !=null && !"".equals(value)){
                sql.append(" and "+key+" like '%"+value+"%' ");
            }
        }
        StudentService studentService = UtilXml.getBeanConfig(StudentService.class);
        List<Student> students = studentService.searchBox(String.valueOf(sql));
        String pageNum = req.getParameter("pageNum");
        int num = 0;
        if (pageNum == null){
            num =1;
        }else {
            num = Integer.parseInt(pageNum);
        }
        PageHelper.startPage(num,6);
        PageInfo<Student> pageInfo = new PageInfo(students);
        req.getSession().setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
