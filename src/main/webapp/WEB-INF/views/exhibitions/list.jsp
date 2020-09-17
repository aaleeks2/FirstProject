<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose exhibition</title>
    <style type="text/css">
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>
<jsp:include page="../common/cap.jsp"/>
<h2>Wybierz galerię</h2>
<ul id="exhibitionList">
        <c:forEach items="${exhibitions}" var="exhibition">
            <li><a href="/gallery/exhibits?exhibitionName=${exhibition.name}">${exhibition.name}</a></li>
        </c:forEach>
</ul>
</body>
</html>
