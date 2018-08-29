<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/14 0014
  Time: 下午 2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加员工信息</title>
    <style>
        .red{
            color: red;
        }
    </style>
</head>
<body>
<%--enctype  上传图片的--%>
<sf:form action="" method="post" enctype="multipart/form-data" modelAttribute="emp">
<table border="1px" cellpadding="0px" cellspacing="0px">


    <tr>
        <td>员工编号</td>
        <td><sf:input type="text" path="empno" /></td>
    </tr>
    <tr>
        <td>员工姓名</td>
        <td><sf:input type="text" path="ename" /><sf:errors path="ename" cssClass="red"></sf:errors> </td>
    </tr>
    <tr>
        <td>工作</td>
        <td><sf:input type="text" path="job" /></td>
    </tr>
   <tr>
        <td>领导编号</td>
        <td>
            <sf:select path="mgr">
                <c:forEach items="${empList}" var="emp">
                    <sf:option value="${emp.mgr}">${emp.mgr}</sf:option>
                </c:forEach>
            </sf:select>
        </td>
    </tr>
    <tr>
        <td>入职日期</td>
        <td><sf:input type="date" path="hiredate" /></td>
    </tr>
    <tr>
        <td>工资</td>
        <td><sf:input type="text" path="sal" /></td>
    </tr>
    <tr>
        <td>奖金</td>
        <td><sf:input type="text" path="comm" /></td>
    </tr>
    <tr>
        <td>部门编号</td>
        <td>
            <sf:select path="deptno">
               <c:forEach items="${depts}" var="dept">
                   <sf:option value="${dept.deptno}">${dept.dname}</sf:option>
               </c:forEach>
            </sf:select>
        </td>
    </tr>
    <tr>
        <td>上传图片</td>
        <td><input type="file" name="upload"/></td>
    </tr>
    <tr>
        <td><sf:button>提交</sf:button> </td>
    </tr>

</table>
</sf:form>
</body>
</html>
