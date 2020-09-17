<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ranking</title>
    <style type="text/css">
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>
<jsp:include page="../common/cap.jsp"/>
<table>
    <tr>
        <th>Nazwa</th>
        <th>Ilość zgłoszeń</th>
    </tr>
    <c:forEach items="${rankingExhibits}" var="notification">
        <tr>
            <td>${notification.exibit.name}</td>
            <td>${notification.exhibit}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
