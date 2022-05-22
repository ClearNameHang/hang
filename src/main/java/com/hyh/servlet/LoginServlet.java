package com.hyh.servlet;



import com.hyh.pojo.User;
import com.hyh.service.UserService;
import com.hyh.utils.UtilXml;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 解决响应乱码
        resp.setContentType("text/html;charset=utf-8");
        UserService userService = UtilXml.getBeanConfig(UserService.class);

        PrintWriter writer = resp.getWriter();
        String name = req.getParameter("user");
        String password = req.getParameter("password");
        String myCode = req.getParameter("verifycode");
        String checkCode = (String)req.getSession().getAttribute("CHECKCODE_SERVER");
        User user = userService.selectByUsername(name);
        if (user == null){
            writer.print("<script>alert(\"用户不存在请先注册\");window.location.href='register.jsp'</script>");
        }else{
            if (user.getPassword().equals(password) && myCode.equalsIgnoreCase(checkCode)){
                req.getSession().setAttribute("user",user);
                writer.print("<script>alert(\"登录成功\")</script>");
                req.getRequestDispatcher("list.jsp").forward(req,resp);
            }else{
                if (!user.getPassword().equals(password) || !myCode.equals(checkCode)){
                    writer.print("<script>alert(\"登录失败，密码或验证码不正确!!!\");window.location.href='login.jsp'</script>");
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
