<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create notification</title>
</head>
<body>
<h4><a href="/gallery/exhibits?exhibitionName=${exhibitionName}">Wróć</a></h4>
<h3>${exhibit.name}</h3>
<form:form modelAttribute="notification" method="post">
    <span>Dział: <form:select path="department" items="${departments}"/></span><br>
    <span>Rodzaj usterki: <form:input path="type"/></span><br>
    <span>Opis usterki: <form:input path="description"/></span><br>
    <form:hidden path="exhibit"/>
    <input type="submit" value="Wyślij">
</form:form>
</body>
</html>
