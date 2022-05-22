package com.hyh.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 验证用户输入的验证码是否和验证码图片中的一样
 *
 * @author hyh
 * @date 2022-05-08
 */
@WebServlet("/myCode")
public class MyCodeServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        // 解决响应乱码
        response.setContentType("text/html;charset=utf-8");
        // 从页面上获取自己输入的验证码
        String myCode = request.getParameter("myCode");
        // 用自己输入的myCode跟session存入的验证码值进行对比
        String checkCode = (String)request.getSession().getAttribute("CHECKCODE_SERVER");
        if(myCode.equalsIgnoreCase(checkCode)){
            response.getWriter().write("验证码正确！");
        }else{
            response.getWriter().write("验证码错误！");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
