<%@ page contentType="text/html;charset=Cp1251" language="java" pageEncoding="Cp1251" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Names out</h1>

<form action="name" method="POST">
    Name <input name="name">
    <input type="submit" name="ok">
</form>

<table border="2">
    <c:forEach items="${applicationScope.names}" var="one">
       <tr>
               <td>${one.value}</td>
       </tr>
    </c:forEach>
</table>
<a href="remove.jsp">remove</a>

</body>
</html>
