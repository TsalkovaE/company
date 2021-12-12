<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<jsp:useBean id="employeebean" scope="request" type="com.example.demo.beans.EmployeeBean"/>
<h1>Total number of employees: </h1>
<h1>${employeebean.size}</h1>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Department</th>
        <th>Preferences</th>
        <th>Salary</th>
        <th>Position</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employeebean.employees}" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.firstName}</td>
            <td>${e.lastName}</td>
            <td>${e.department}</td>
            <td>${e.preference}</td>
            <td>${e.salary}</td>
            <td>${e.position}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
