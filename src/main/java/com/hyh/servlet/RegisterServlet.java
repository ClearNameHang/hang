package com.hyh.servlet;

import com.hyh.pojo.User;
import com.hyh.service.UserService;
import com.hyh.service.impl.UserServiceImpl;
import com.hyh.utils.UtilXml;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author 潮7000
 * @vesion 1.0
 * @date 2022/5/12 9:18
 */

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        User user = new User();
        user.setId(UUID.randomUUID().toString().substring(2,6));
        Map<String, String[]> map = req.getParameterMap();
        // 把String类型==》Date类型

        ConvertUtils.register(new Converter() {
            /**
             *
             * @param clazz 表示目标的数据类型
             * @param value  表示要转换的数据
             * @return Object
             */
            @Override
            public Object convert(Class clazz, Object value) {
                // 创建格式化对象
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                try {
                    date = sdf.parse((String)value);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return date;
            }
        }, Date.class);

        // 统一用一个工具类  BeanUtils.populate()把map集合封装到student中
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService userService = UtilXml.getBeanConfig(UserService.class);
        User user1 = userService.selectByUsername(username);
        if (user1 == null){
            int i = userService.insertUser(user);
            if (i == 1){
                resp.sendRedirect("login.jsp");
            }else{
                resp.sendRedirect("register.jsp");
            }
        }else{
            resp.getWriter().write("<script>alert(\"用户已经存在请重新注册\");window.location.href='register.jsp</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
