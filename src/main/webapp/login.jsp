<%--
  Created by IntelliJ IDEA.
  User: 潮7000
  Date: 2022/5/12
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-1.11.2.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="/js/bootstrap.min.js"></script>

</head>


<body>
    <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">管理员登录</h3>
        <form action="login" method="get">
            <div class="form-group">
                <label for="user">用户名：</label>
                <input type="text" name="user" class="form-control" id="user" placeholder="请输入用户名"/>
            </div>

            <div class="form-group">
                <label for="password">密码：</label>
                <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
            </div>

            <div class="form-inline">
                <label for="vcode">验证码：</label>
                <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
                <img src="checkCode" title="看不清点击刷新" id="vcode" onclick="changeCheckCode(this)"/>
                <span id="spanId" style="color: red"></span>
                <script type="text/javascript">
                    //图片点击事件
                    function changeCheckCode(img) {
                        img.src="checkCode?"+new Date().getTime();
                    }
                </script>
            </div>
            <hr/>
            <div class="form-group" style="text-align: center;">
                <input class="btn btn btn-primary" type="submit" value="登录">
            </div>
        </form>
    </div>
<%--    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" >
            <span>&times;</span>
        </button>
        <strong>登录失败!</strong>
    </div>--%>
    <script>
        $(function () {
            $("#verifycode").on("blur",function () {
                $.ajax({
                    url:"myCode",
                    method:"get",
                    data:"myCode="+$("#verifycode").val(),
                    dataType:"text",
                    success:function (result) {
                        $("#spanId").html(result);
                    }
                })
            })
        })
    </script>
</body>
</html>

