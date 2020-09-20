<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notification list</title>
    <style type="text/css">
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>
<jsp:include page="../common/cap.jsp"/>
<c:if test="${count == 0}">
    <h3>Brak zgłoszeń</h3>
</c:if>
<c:if test="${count > 0}">
<h2>Workshop notification list</h2>
    <c:forEach items="${notificationsWorkshop}" var="notification">
        <ul class="homeList">
            <li>${notification.id}</li>
            <li>${notification.exhibit.name}</li>
            <li>${notification.type}</li>
            <li>${notification.created}</li>
            <li><a href="/notification/details?notificationId=${notification.id}">Szczegóły</a></li>
            <li>
        <c:if test="${notification.taken == 1}">
            <span style="color: green">Zgłoszenie przejęte przez <b>${notification.user.name} ${notification.user.surname} ${notification.user.phoneNumber}</b></span>
        </c:if>
        <c:if test="${notification.closed == 1}">
            <span style="background-color: green; color: black">Zgłoszenie zamknięte</span>
        </c:if>
            </li>
        </ul>
    </c:forEach>
</c:if>
</body>
</html>
