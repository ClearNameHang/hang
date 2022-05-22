<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 潮7000
  Date: 2022/5/12
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-1.11.2.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <script src="js/sort.js"></script>

    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        $(function () {
            $("#checkAll").on("click",function () {
                $("td input:checkbox").prop("checked",this.checked)
            })
        })

        function deleteStudent(id) {
            if(confirm("你确定要删除吗？")){
                window.location.href="${pageContext.request.contextPath}/delete?id="+id;
            }
        }
        function updateStudent(id) {
            window.location.href="${pageContext.request.contextPath}/selectById?id="+id;
        }
        
        function delSelStudent() {
            if(confirm("你确定要删除吗？")){
                var ids = $("input[name=ids]");
                var flag = false;
                for(var i=0;i<ids.length;i++){
                    if(ids[i].checked){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    $("#form").submit();
                }
            }
        }
    </script>
    </div>
</head>
<body>
<div class="container">


    <h3 style="text-align: center"><a href="${pageContext.request.contextPath}/list">查询用户信息列表</a></h3>

    <div class="col-md-4" role="navigation">
        <!-- <h1 style="font-size: 20px;margin-top: 9px">东大咸鱼</h1> -->

        <ul class="nav nav-pills">
            <c:if test="${empty sessionScope.user}">
                <li><a href="${pageContext.request.contextPath}/login.jsp" style="color: #F22E00">请登录</a></li>
                <li><a href="${pageContext.request.contextPath}/register.jsp" style="color: #F22E00">注册</a></li>
            </c:if>
            <c:if test="${!empty sessionScope.user}">
                <li class="info-a">
                    <a href="#" style="color: #F22E00">
                            ${sessionScope.user.username}
                        <span class="glyphicon glyphicon-triangle-bottom" style="font-size: 5px;margin-left: 7px;" aria-hidden="true">
                        </span>
                    </a>
                    <ul class="dropdown-menu">
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/logout" class="login-out">退出登录</a></li>
                    </ul>
                </li>
            </c:if>

        </ul>
    </div>

    <div style="float: left;">

        <form action="${pageContext.request.contextPath}/searchBox " method="post" class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" value="${queryCondition.name[0]}"class="form-control" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputName3">性别</label>
                <input type="text" name="gender" value="${queryCondition.gender[0]}" class="form-control" id="exampleInputName3" >
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">籍贯</label>
                <input type="text" name="address" value="${queryCondition.address[0]}" class="form-control" id="exampleInputEmail2"  >
            </div>
            <button type="submit" class="btn btn-default">搜索</button>
        </form>

    </div>

    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:delSelStudent();">删除选中</a>

    </div>
    <form id="form" action="${pageContext.request.contextPath}/batchDelete" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="checkAll"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pageInfo.list}" var="student" varStatus="status">
                <tr>
                    <td><input type="checkbox" name="ids" value="${student.id}"></td>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.gender}</td>
                    <td>${student.age}</td>
                    <td>${student.address}</td>
                    <td>${student.qq}</td>
                    <td>${student.email}</td>
                        <%--<td><a class="btn btn-default btn-sm" href="update.jsp">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="">删除</a></td>--%>
                    <td><a class="btn btn-default btn-sm" href="javascript:updateStudent(${student.id})">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteStudent(${student.id})">删除</a></td>
                </tr>
            </c:forEach>

        </table>

    </form>

    <div>
        <nav aria-label="Page navigation">

            <ul class="pagination">

                <%--<c:if test="${pageInfo.pages == 1}">
                <li>
                    </c:if>
                </li>
                <c:if test="${pageInfo.pages != 1}">
                <li>
                    </c:if>--%>
                <li>
                    <a href="${pageContext.request.contextPath}/list?pageNum=${pageInfo.pageNum - 1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>


                <c:forEach begin="1" end="${pageInfo.pages}" var="i" >

                    <c:if test="${pageInfo.pageNum == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/list?pageNum=${i}">${i}</a></li>
                    </c:if>

                    <c:if test="${pageInfo.pageNum != i}">
                        <li><a href="${pageContext.request.contextPath}/list?pageNum=${i}">${i}</a></li>
                    </c:if>

                </c:forEach>



                <li>
                    <a href="${pageContext.request.contextPath}/list?pageNum=${pageInfo.pageNum + 1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>


                <span style="font-size: 25px;margin-left: 5px;">
                    共${pageInfo.total}条记录，共${pageInfo.pages}页
                </span>
            </ul>

        </nav>
    </div>
    <script>

    </script>
</div>
</body>
</html>
