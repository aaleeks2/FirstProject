<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create notification</title>
    <style type="text/css">
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>
<jsp:include page="../common/cap.jsp"/>
<h4><a href="/gallery/exhibits?exhibitionName=${exhibitionName}">Wróć</a></h4>
<h3>${exhibit.name}</h3>
<form:form modelAttribute="notification" method="post">
    <span>Dział: <form:select path="department" items="${departments}"/></span><br>
    <span>Typ usterki: <form:select path="type" items="${notificationTypes}"/></span><br>
    <span>Opis usterki: <form:textarea path="description"/></span><br>
    <form:hidden path="exhibit"/>
    <input type="submit" value="Wyślij">
</form:form>
<div id="notificationHistory">
    <h3>Historia zgłoszeń</h3>
    <c:forEach items="${notificationHistory}" var="notification">
        <table>
            <tr>
                <td>Numer identyfikacyjny zgłoszenia: ${notification.id}</td>
            </tr>
            <tr>
                <td>Dział: ${notification.department}</td>
            </tr>
            <tr>
                <td>Data zgłoszenia: ${notification.created}</td>
            </tr>
            <tr>
                <td>Typ zgłoszenia: ${notification.type}</td>
            </tr>
            <c:if test="${notification.taken == 1 && notification.closed==0}">
                <tr>
                    <td><div style="background-color: red">Zgłoszenie przejęte</div></td>
                </tr>
            </c:if>
            <c:if test="${notification.closed==1}">
                <tr>
                    <td><div style="background-color: green">Zgłoszenie zamknięte</div></td>
                </tr>
            </c:if>
        </table>
    </c:forEach>
</div>
</body>
</html>
