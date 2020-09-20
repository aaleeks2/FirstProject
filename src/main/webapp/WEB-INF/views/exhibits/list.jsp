<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose exhibit</title>
    <style type="text/css">
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>
<jsp:include page="../common/cap.jsp"/>
<h3><a class="backBtn" href="/gallery/exhibitions">Wróć</a></h3>
<h2>${exhibition.name}</h2>
    <c:forEach items="${exhibitsOfExhibition}" var="exhibit" >
        <ul class="homeList">
            <li>${exhibit.id}</li>
            <li>${exhibit.name}</li>
            <li><a href="/gallery/notification?exhibitName=${exhibit.name}&exhibitionName=${exhibition.name}">Zgłoś</a></li>
        </ul>
    </c:forEach>
</body>
</html>
