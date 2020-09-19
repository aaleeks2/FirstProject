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
    <div class="container">
        <a href="/gallery/exhibitions" id="imgBtn">Lista galerii</a>
    </div>
    <div class="container1">
        <a href="/notification/ranking" id="imgBtn2">Ranking zgłoszeń eksponatów</a>
    </div>
<%--    <ul class="homeList">--%>
<%--        <li><a href="/gallery/exhibitions">Lista galerii</a></li>--%>
<%--    </ul>--%>
<%--    <ul class="homeList">--%>
<%--        <li><a href="/gallery/ranking">Ranking najczęściej zgłaszanych eksponatów</a></li>--%>
<%--    </ul>--%>
</sec:authorize>
<sec:authorize access="hasRole('it')">
        <ul class="homeList">
            <li><a href="/notification/it/list">List zgłoszeń IT</a></li>
        </ul>
        <ul class="homeList">
            <li><a href="/notification/history">Historia zgłoszeń</a></li>
        </ul>
</sec:authorize>
<sec:authorize access="hasRole('workshop')">
        <ul class="homeList">
            <li><a href="/notification/workshop/list">List zgłoszeń Warsztat</a></li>
        </ul>
        <ul class="homeList">
            <li><a href="/notification/history">Historia zgłoszeń</a></li>
        </ul>
</sec:authorize>
</body>
</html>
