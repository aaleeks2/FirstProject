<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose exhibit</title>
</head>
<body>
<h3><a href="/gallery/exhibitions">Wróć</a></h3>
<h2>${exhibition.name}</h2>
<table>
    <c:forEach items="${exhibitsOfExhibition}" var="exhibit" >
        <tr>
            <td>${exhibit.id}   ||  ${exhibit.name}     <a href="/gallery/notification?exhibitName=${exhibit.name}&exhibitionName=${exhibition.name}">Zgłoś</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
