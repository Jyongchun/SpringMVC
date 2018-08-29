<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/16 0016
  Time: 上午 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<sf:form action="" method="post" enctype="multipart/form-data" modelAttribute="emp">
    <table border="1px" cellpadding="0px" cellspacing="0px">

        <tr>
            <td>员工编号</td>
            <td><sf:input type="text" path="empno" value="${emp.empno}" /></td>
        </tr>
        <tr>
            <td>员工姓名</td>
            <td><sf:input type="text" path="ename" value="${emp.ename}"/></td>
        </tr>
        <tr>
            <td>工作</td>
            <td><sf:input type="text" path="job" value="${emp.job}"/></td>
        </tr>
        <tr>
            <td>领导编号</td>
            <td>
                <sf:select path="mgr">
                    <c:forEach items="${empList}" var="emplist">
                       <c:choose>
                           <c:when test="${emplist.mgr==emp.mgr}">
                               <sf:option selected="selected"  value="${emplist.mgr}">${emplist.mgr}</sf:option>
                           </c:when>
                           <c:otherwise>
                               <sf:option value="${emplist.mgr}">${emplist.mgr}</sf:option>
                           </c:otherwise>
                       </c:choose>
                    </c:forEach>
                </sf:select>
            </td>
        </tr>
        <tr>
            <td>入职日期</td>
            <td><sf:input type="date" path="hiredate" value="${emp.hiredate}"/></td>
        </tr>
        <tr>
            <td>工资</td>
            <td><sf:input type="text" path="sal" value="${emp.sal}"/></td>
        </tr>
        <tr>
            <td>奖金</td>
            <td><sf:input type="text" path="comm" value="${emp.comm}" /></td>
        </tr>
        <tr>
            <td>部门编号</td>
            <td>
                <sf:select path="deptno">
                    <c:forEach items="${depts}" var="dept">
                       <c:choose>
                           <c:when test="${dept.deptno==emp.deptno}">
                               <sf:option  value="${dept.deptno}" selected="selected">${dept.dname}</sf:option>
                           </c:when>
                           <c:otherwise>
                               <sf:option  value="${dept.deptno}">${dept.dname}</sf:option>
                           </c:otherwise>
                       </c:choose>
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
</body>
</html>
