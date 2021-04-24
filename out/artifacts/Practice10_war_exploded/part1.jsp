<%--
  Created by IntelliJ IDEA.
  User: Дарина
  Date: 01.11.2019
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <!-- 1 str -->
    <tr>
        <td></td>
        <%
            for(int j=1; j<10; j++){
        %>
        <td><%=j%></td>
        <%
            }
        %>
    </tr>
    <!-- n str -->
    <%
        for(int i=1; i<10; i++){
    %>
    <tr>
        <!-- 1 stolb -->
        <td><%=i%></td>
        <!-- 1 stolb -->
        <!-- n stolb -->
        <%
            for(int k=1; k<10; k++){
        %>
        <td><%=i*k%></td>
        <%
            }
        %>
        <!-- n stolb -->
    </tr>
    <%
        }
    %>
    <!-- n str -->
</table>
</body>
</html>
