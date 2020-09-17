<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        <%@include file="../../css/style.css" %>
    </style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js" integrity="sha512-WNLxfP/8cVYL9sj8Jnp6et0BkubLP31jhTG9vhL/F5uEZmg5wEzKoXp1kJslzPQWwPT1eyMiSxlKCgzHLOTOTQ==" crossorigin="anonymous"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/buttonScript.js"></script>
    <title>Notification details</title>
</head>
<body>
<jsp:include page="../common/cap.jsp"/>
<h3><a href="/notification/${notification.department}/list">Powrót</a></h3>
<h2>${notification.exhibit.name}</h2>
<div class="flex-container">
<table>
    <tr>
        <td>Galeria: ${notification.exhibit.exhibition.name}</td>
    </tr>
    <tr>
        <td>Czas zgłoszenia: ${notification.created}</td>
    </tr>
    <tr>
        <td>Rodzaj usterki: ${notification.type}</td>
    </tr>
    <tr>
        <td>Opis usterki: ${notification.description}</td>
    </tr>
    <c:if test="${notification.taken == 0}">
        <tr>
            <td><a id="takeLink" href="/notification/${notification.department}/taken?notId=${notification.id}" onclick="function x() {
              var takeLink = $('#takeLink');
              takeLink.hide();
            }">Przyjmij</a></td>
        </tr>
    </c:if>
    <c:if test="${notification.taken == 1}">
        <tr>
            <td>
                <a href="/notification/${notification.department}/close?notId=${notification.id}" onclick="confirm('Zamknij zgłoszenie')">ZAMKNIJ</a>
            </td>
        </tr>
    </c:if>
</table>
</div>
</body>
</html>