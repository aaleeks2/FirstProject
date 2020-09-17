<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index page</title>
    <style type="text/css">
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>
<jsp:include page="cap.jsp"/>
<sec:authorize access="hasRole('user')">
    <div><a href="/gallery/exhibitions">Lista galerii</a></div>
    <div><a href="/gallery/ranking">Ranking najczęściej zgłaszanych eksponatów</a></div>
</sec:authorize>
<sec:authorize access="hasRole('it')">
    <div><a href="/notification/it/list">List zgłoszeń IT</a></div>
    <div><a href="/notification/history">Historia zgłoszeń</a></div>
</sec:authorize>
<sec:authorize access="hasRole('workshop')">
    <div><a href="/notification/workshop/list">List zgłoszeń Warsztat</a></div>
    <div><a href="/notification/history">Historia zgłoszeń</a></div>
</sec:authorize>
</body>
</html>
