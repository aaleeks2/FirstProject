<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access denied</title>
    <style type="text/css">
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>
<h2>Nie masz uprawnień do otworzenia tej witryny. Skontaktuj się z administratorem.</h2>
<sec:authorize access="hasRole('ROLE_USER')">
    <a href="/gallery/exhibitions">Wróc do listy galerii</a>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_IT')">
    <a href="/notification/it/list">Wróc do listy zgłoszeń</a>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_WORKSHOP')">
    <a href="/notification/workshop/list">Wróc do listy zgłoszeń</a>
</sec:authorize>
</body>
</html>
