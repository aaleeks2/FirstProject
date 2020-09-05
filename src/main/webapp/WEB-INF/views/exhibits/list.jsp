<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose exhibit</title>
</head>
<body>
<h2>${exhibition.name}</h2>
<table>
    <c:forEach items="${exhibitsOfExhibition}" var="exhibit" >
        <tr>
            <td>${exhibit.id}   ||  ${exhibit.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
