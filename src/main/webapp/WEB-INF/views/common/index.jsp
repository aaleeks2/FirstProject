<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index page</title>
</head>
<body>
<jsp:include page="cap.jsp"/>
<sec:authorize access="hasRole('user')">
<a href="/gallery/exhibitions">Lista galerii</a>
</sec:authorize>
<sec:authorize access="hasRole('it')">
    <a href="/notification/it/list">List zgłoszeń IT</a>
</sec:authorize>
<sec:authorize access="hasRole('workshop')">
    <a href="/notification/workshop/list">List zgłoszeń Warsztat</a>
</sec:authorize>
</body>
</html>
