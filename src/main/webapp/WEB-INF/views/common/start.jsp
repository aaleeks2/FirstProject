<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <style type="text/css">
        <%@include file="../../css/style.css" %>
        h1{
            text-align: center;
        }

        #loginContainer{
            position: relative;
            width: 50%;
        }

        #loginContainer img {
            width: 100%;
            height: auto;
        }

        #loginContainer button{
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            background-color: #555;
            color: white;
            font-size: 16px;
            padding: 12px 24px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }

        #loginContainer button a{
            color: white;
        }

        #loginContainer button:hover{
            background-color: black;
        }

    </style>
</head>
<body>
<h1>Aplikacja zgłoszeniowa CNK_01</h1>
<div id="loginContainer">
    <img src="/img/warszawa-centrum-nauki-kopernik.jpg" alt="CNK">
    <button><a href="/login">Zaloguj się</a></button>
</div>
</body>
</html>
