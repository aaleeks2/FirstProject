<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
    <style type="text/css">
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>
<c:if test="${ param.error != null}">
    <p>Błędne dane logowania.</p>
</c:if>
<form:form method="post">
    <div id="imgContainer">
        <img
    </div>
    <div id="loginDiv">
        <label for="username" ><b>Username</b></label>
        <input  id="username" type="text" placeholder="Nazwa użytkownika" name="username" required>
        <label for="password"><b>Password</b></label>
        <input id="password" type="password" name="password"/>
        <input type="submit" value="Sign In"/>
    </div>
</form:form>
</body>
</html>
