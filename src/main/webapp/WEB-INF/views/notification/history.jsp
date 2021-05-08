<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
    <style type="text/css">
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>
<jsp:include page="../common/cap.jsp"/>
<table id="historyTable">
    <tr>
        <th>DATA</th>
        <th>ID</th>
        <th>EKSPONAT</th>
        <th>TYP</th>
        <th>OPIS</th>
    </tr>
    <c:forEach items="${historyOfNotifications}" var="notification">
    <tr>
        <td>${notification.created}</td>
        <td>${notification.id}</td>
        <td>${notification.exhibit.name}</td>
        <td>${notification.type}</td>
        <td>${notification.description}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
