<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new employee</title>
</head>
<body>
<jsp:useBean id="departmentbean" scope="request" class="com.example.demo.beans.DepartmentBean"/>
<form name="newempl" action="results.jsp" method="post">
    <table>
        <tbody>
        <tr>
            <td>First name: </td>
            <td><label>
                <input type="text" name="first" value="" size="20"/>
            </label></td>
        </tr>
        <tr>
            <td>Last name: </td>
            <td><input type="text" name="last" value="" size="20"/></td>
        </tr>
        <tr>
            <td>Department: </td>

            <label>
                <select>
                    <c:forEach items="${departmentbean.departments}" var="d">
                        <option>${d.title}</option>
                    </c:forEach>
                </select>
            </label>


        </tr>

        <tr>
            <td>Preference: </td>
            <td><input type="text" name="preference" value="" size="10"/></td>
        </tr>
        <tr>
            <td>Position: </td>
            <td><input type="text" name="position" value="" size="20"/></td>
        </tr>
        </tbody>
    </table>
    <input type="reset" value="Clear" name="clear"/>
    <input type="submit" value="Submit" name="submit"/>

</form>
</body>
</html>
