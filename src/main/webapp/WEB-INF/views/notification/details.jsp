<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notification details</title>
    <script src="../../js/script.js"></script>
</head>
<body>
<h3><a href="/notification/list/${notification.department}">Powrót</a></h3>
<h2>${notification.exhibit.name}</h2>
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
    <tr>
        <td><a href="notification/details/images">Zdjęcia</a></td>
    </tr>
    <tr>
<%--TODO - create function in js/scirpt.js which is going to put information if notification is taken--%>
        <td><button type="button" name="takenButton" id="takenBtn">Przyjmij</button></td>
    </tr>
</table>
</body>
</html>
