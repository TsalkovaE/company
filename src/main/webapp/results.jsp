<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New employee</title>
</head>
<body>
    <jsp:useBean id="employee" type="com.example.demo.data.Employee" scope="request"/>
    <h1>${employee.firstName}</h1>
    <h1>${employee.lastName}</h1>
    <h1>${employee.department}</h1>
    <h1>${employee.position}</h1>
</body>
</html>