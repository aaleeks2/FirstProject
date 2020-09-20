<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact</title>
    <style type="text/css">
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>
<jsp:include page="cap.jsp"/>
<h2>Kontakt do pracowników serwisowych</h2>
<h3>Warsztat:</h3>
    <ul>
        <c:forEach items="${employees}" var="employee">
        <c:if test="${employee.department == 'Workshop'}">
            <li>${employee.name}    ${employee.surname}    ${employee.email}    ${employee.phoneNumber}</li>
        </c:if>
        </c:forEach>
    </ul>
<h3>It:</h3>
    <ul>
        <c:forEach items="${employees}" var="employee">
        <c:if test="${employee.department == 'It'}">
            <li>${employee.name}    ${employee.surname}    ${employee.email}    ${employee.phoneNumber}</li>
        </c:if>
        </c:forEach>
    </ul>
</body>
</html>
