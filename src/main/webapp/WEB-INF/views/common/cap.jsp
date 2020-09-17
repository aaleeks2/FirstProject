<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style type="text/css">
    <%@include file="../../css/style.css" %>
</style>
<sec:authorize access="isAuthenticated()">
    <ul id="nav">
        <li><a href="/homePage">Home</a></li>
        <li><a href="/contact">Kontakt</a></li>
        <li><sec:authorize access="hasRole('user')"><a href="/notification/history">Historia zgłoszeń</a></sec:authorize></li>
        <li class="plainText">Użytkownik: <sec:authentication property="principal.username"/></li>
        <li class="plainText">Rola: <sec:authentication property="principal.authorities"/></li>
        <li><form id="logoutBtn" action="/logout" method="post">
            <input type="submit" value="Wyloguj">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form></li>
    </ul>
<%--    <form id="logoutBtn" action="/logout" method="post">--%>
<%--        <input type="submit" value="Wyloguj">--%>
<%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--    </form>--%>
</sec:authorize>