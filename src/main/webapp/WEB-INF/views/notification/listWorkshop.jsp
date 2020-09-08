<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notification list</title>
</head>
<body>
<h2>Workshop notification list</h2>
<table>
    <%--    TODO - have to create function, which will be granting acces to certain pages whether its workshop or IT--%>
    <c:forEach items="${notificationsWorkshop}" var="notification">
        <tr>
            <td>
                    ${notification.id}  ||   ${notification.type}   ||  ${notification.created}
                <a href="/notification/details?notificationId=${notification.id}">Szczegóły</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
