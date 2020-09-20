<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        <%@include file="../../css/style.css" %>
    </style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js" integrity="sha512-WNLxfP/8cVYL9sj8Jnp6et0BkubLP31jhTG9vhL/F5uEZmg5wEzKoXp1kJslzPQWwPT1eyMiSxlKCgzHLOTOTQ==" crossorigin="anonymous"></script>
    <title>Notification details</title>
</head>
<body>
<jsp:include page="../common/cap.jsp"/>
<h3><a class="backBtn" href="/notification/${notification.department}/list">Powrót</a></h3>
<h2>${notification.exhibit.name}</h2>
    <ul class="homeList">
        <li>Galeria: ${notification.exhibit.exhibition.name}</li>
        <li>Czas zgłoszenia: ${notification.created}</li>
        <li>Rodzaj usterki: ${notification.type}</li>
        <li>Opis usterki: ${notification.description}</li>
    <c:if test="${notification.taken == 0}">
        <li><a id="takeLink" href="/notification/${notification.department}/taken?notId=${notification.id}&username=<sec:authentication property="principal.username"/>"
              onclick="function x() { var takeLink = $('#takeLink'); takeLink.hide();}">Przyjmij</a>
        </li>
    </c:if>
    <c:if test="${notification.taken == 1}">
        <li><span>Zlecenie przejęte przez: <b>${notification.user.name} ${notification.user.surname} ${notification.user.phoneNumber}</b></span></li>
        <li><a href="/notification/${notification.department}/close?notId=${notification.id}" onclick="return confirm('Zamknij zgłoszenie')">ZAMKNIJ</a></li>
    </c:if>
    </ul>
</body>
</html>