<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<h1><%= "Welcome to the Company's webapp!"%></h1>
<h2>Choose an option:</h2>
<br/>
<form method="get" action="employees.html">
    <input type="submit" value="Show all employees" name="allemployees"/><br/>
</form>
<form method="get" action="departments.html">
    <input type="submit" value="Show all departments" name="alldepartments"/>
</form>
<form method="post" action="newemployee.html">
    <input type="submit" value="Add new employee" name="newemployee"/>
</form>
</body>
</html>