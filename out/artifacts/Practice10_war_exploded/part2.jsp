<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <!-- 1 str -->
    <tr>
        <td></td>
        <c:forEach var="j" begin="1" end="9" step="1">
        <td>${j}</td>
        </c:forEach>

    </tr>


        <c:forEach var="i" begin="1" end="9" step="1">
    <tr>
            <td>${i}</td>
            <c:forEach var="k" begin="1" end="9" step="1">
                <td>${k*i}</td>
            </c:forEach>
    </tr>
        </c:forEach>



</table>
</body>
</html>
