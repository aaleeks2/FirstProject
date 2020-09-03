<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose exhibition</title>
</head>
<body>
<h2>Wybierz galerię</h2>
<table>
        <c:forEach items="${exhibitions}" var="exhibition">
            <tr>
<%--            TODO linkacz do listy eksponatow--%>
            <td>${exhibition.name}</td>
            </tr>
        </c:forEach>
</table>
</body>
</html>
