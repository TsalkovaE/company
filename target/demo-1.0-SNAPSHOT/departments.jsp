<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Departments</title>
</head>
<body>
<jsp:useBean id="departmentbean" scope="request" type="com.example.demo.beans.DepartmentBean"/>
<h1>Departments: </h1>
<h1>${departmentbean.size}</h1>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Type of salary</th>
        <th>Employees</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${departmentbean.departments}" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.title}</td>
            <td>${e.typeOfSalary}</td>
            <td>${e.employees}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
