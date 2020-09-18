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
<h4><a class="backBtn" href="/gallery/exhibits?exhibitionName=${exhibitionName}">Wróć</a></h4>
<h2>${exhibit.name}</h2>
<div id="addNotFormDiv">
<form:form modelAttribute="notification" method="post" cssClass="addNotForm">
    <label><b>Dział:</b></label>
    <form:select path="department" items="${departments}"/>
    <label><b>Typ usterki:</b></label>
    <form:select path="type" items="${notificationTypes}"/>
    <label><b>Opis usterki:</b></label>
    <form:textarea path="description" />
    <form:hidden path="exhibit"/>
    <input type="submit" value="Wyślij">
<%--    <span>Dział: <form:select path="department" items="${departments}"/></span><br>--%>
<%--    <span>Typ usterki: <form:select path="type" items="${notificationTypes}"/></span><br>--%>
<%--    <span>Opis usterki: <form:textarea path="description"/></span><br>--%>
<%--    <form:hidden path="exhibit"/>--%>
<%--    <input type="submit" value="Wyślij">--%>
</form:form>
</div>
    <h3>Historia zgłoszeń</h3>
    <c:forEach items="${notificationHistory}" var="notification">
        <ul class="homeList">
            <li><b>Numer identyfikacyjny zgłoszenia:</b> ${notification.id}</li>
            <li><b>Dział:</b> ${notification.department}</li>
            <li><b>Data zgłoszenia:</b> ${notification.created}</li>
            <li><b>Typ zgłoszenia:</b> ${notification.type}</li>
            <c:if test="${notification.taken == 1 && notification.closed==0}">
            <li style="background-color: red">Zgłoszenie przejęte</li>
            </c:if>
            <c:if test="${notification.closed==1}">
            <li style="background-color: green">Zgłoszenie zamknięte</li>
            </c:if>
        </ul>
    </c:forEach>
</body>
</html>
