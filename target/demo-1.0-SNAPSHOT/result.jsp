<jsp:useBean id="bean" scope="request" type="com.example.demo.beans.EfficiencyBean"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Efficiency</title>
</head>
<body>
<h1>Efficiency is ${bean.efficiencyNum}</h1>
</body>
</html>
