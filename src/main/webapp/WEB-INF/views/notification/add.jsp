<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create notification</title>
</head>
<body>
<jsp:include page="../common/cap.jsp"/>
<h4><a href="/gallery/exhibits?exhibitionName=${exhibitionName}">Wróć</a></h4>
<h3>${exhibit.name}</h3>
<form:form modelAttribute="notification" method="post">
    <span>Dział: <form:select path="department" items="${departments}"/></span><br>
    <span>Rodzaj usterki: <form:input path="type"/></span><br>
    <span>Opis usterki: <form:input path="description"/></span><br>
    <form:hidden path="exhibit"/>
    <input type="submit" value="Wyślij">
</form:form>
<div id="notificationHistory">
    <h3>Historia zgłoszeń</h3>
    <c:forEach items="${notificationHistory}" var="notification">
        <table>
            <tr>${notification.id}</tr>
            <tr>${notification.department}</tr>
            <tr>${notification.created}</tr>
            <tr>${notification.type}</tr>
        </table>
    </c:forEach>
</div>
</body>
</html>
