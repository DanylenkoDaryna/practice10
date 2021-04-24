<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Log In</h1>

<form action="/authorize" method="post">

    login <input name="login"><br>
    password <input name="password" type="password">
    <br>
    <%
        request.getAttribute("con");
    %>

    <input type="submit" name="ok">

</form>
</body>
</html>
