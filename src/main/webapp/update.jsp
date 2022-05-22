<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 潮7000
  Date: 2022/5/13
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <%--<base href="<%=basePath%>"/>--%>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>

<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/updateStudent?id=${student.id}" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  value="${student.name}" placeholder="请输入姓名" />
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${student.gender == '男'}">
                <input type="radio" name="gender" value="男" checked  />男
                <input type="radio" name="gender" value="女"  />女
            </c:if>
            <c:if test="${student.gender == '女'}">
                <input type="radio" name="gender" value="男"   />男
                <input type="radio" name="gender" value="女" checked />女
            </c:if>

        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"  name="age" value="${student.age}" placeholder="请输入年龄" />
        </div>



            <div class="form-group">
                <label for="address">籍贯：</label>
                <input name="address" id="address" class="form-control" value="${student.address}">
            </div>



        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq" class="form-control" name="qq" value="${student.qq}" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" name="email" value="${student.email}" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>