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
<h2>IT notification list</h2>
<%--    TODO - have to create function, which will be granting acces to certain pages whether its workshop or IT--%>
    <c:forEach items="${notificationsIT}" var="notification">
    <div class="flex-container">
        <table>
        <tr>
            <td>${notification.id}</td>
        </tr>
        <tr>
            <td>${notification.type}</td>
        </tr>
        <tr>
            <td>${notification.created}</td>
        </tr>
        <tr>
            <td><a href="/notification/details?notificationId=${notification.id}">Szczegóły</a></td>
        </tr>
        <tr>
            <td>
                <c:if test="${notification.taken == 1 && notification.closed != 1}">
                    <div style="color: green">Zgłoszenie przejęte</div>
                </c:if>
                <c:if test="${notification.closed == 1}">
                    <div style="background-color: green; color: black">Zgłoszenie zamknięte</div>
                </c:if>
            </td>
        </tr>
        </table>
    </div>
    </c:forEach>
</body>
</html>
