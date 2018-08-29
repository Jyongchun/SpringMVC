<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/13 0013
  Time: 下午 4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .img{
        width: 50px;
        height: 50px;
    }
</style>
<body>
<h1>查看</h1>

<h3><a href="http://localhost:8080/emp/add">添加员工信息</a></h3>
    <table border="1px" cellspacing="0px" cellpadding="1px">
       <tr>
        <th>员工头像</th>   
        <th>员工编号</th>
        <th>员工姓名</th>
        <th>员工工作</th>
        <th>领导编号</th>
        <th>入职日期</th>
        <th>工资</th>
        <th>奖金</th>
        <th>部门编号</th>
        <th>操作</th>
       </tr>

    <c:forEach items="${empList}" var="emp">
        <tr>
            <td><img src="${emp.url} " class="img"></td>
            <td>${emp.empno}</td>
            <td>${emp.ename}</td>
            <td>${emp.job}</td>
            <td>${emp.mgr}</td>
            <td>${emp.hiredate}</td>
            <td>${emp.sal}</td>
            <td>${emp.comm}</td>
            <td>${emp.deptno}</td>
            <td>
                <a href="update/${emp.empno}">修改</a>
                <a href="delete/${emp.empno}">删除</a>
            </td>
        </tr>
    </c:forEach>

  </table>
</body>
</html>
