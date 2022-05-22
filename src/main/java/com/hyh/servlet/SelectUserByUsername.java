package com.hyh.servlet;

import com.hyh.pojo.User;
import com.hyh.service.UserService;
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
 * @date 2022/5/14 23:08
 */
@WebServlet("/checkUsernameServlet")
public class SelectUserByUsername extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UtilXml.getBeanConfig(UserService.class);
        String username = req.getParameter("username");
        User user = userService.selectByUsername(username);
        if (user != null){
            resp.getWriter().write("用户已经存在！！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
