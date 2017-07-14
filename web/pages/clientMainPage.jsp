<%--Created by Yauheni Hermanovich 14.07.2017--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="spec"%>
<html>
    <head>
        <title>Clients account page</title>
        <style type="text/css">
            body {
                margin: 0px;
                padding: 0px;
                display: inline-block;
                background: url("/images/bg_registration.jpg") no-repeat center center fixed;
                background-size: cover;
            }
        </style>
    </head>
    <body>
        <h2>Welcome to Airline Company, <i>${sessionScope.login}</i>!</h2>
    </body>
</html>
