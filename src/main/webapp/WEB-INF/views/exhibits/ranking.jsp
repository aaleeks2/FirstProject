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
<table id="historyTable">
    <tr>
        <th>Galeria</th>
        <th>Nazwa eksponatu</th>
        <th>Liczba zgłoszeń</th>
    </tr>
    <c:forEach items="${exhibitRanking}" var="exhibit">
        <tr>
            <td>${exhibit.exhibition.name}</td>
            <td>${exhibit.name}</td>
            <td>${exhibit.countNotifications()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
