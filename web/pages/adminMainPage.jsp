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
            .data {
                position: fixed;
                left: 15px;
            }
            #usertypeelem {
                position: fixed;
                left: 10px; bottom: 10px;
                color: firebrick;
            }
            #logoutelem {
                position: fixed;
                right: 25px; top: 25px;
                color: firebrick;
            }
        </style>
    </head>
    <body>
        <div class="data">
            <h3>Administration service of Airline Company. <i>${user.getFirstName()} ${user.getSurname()}</i>.</h3>
            <div id="logoutelem">
                <form name="logout" method="POST" action="controller">
                    <input type="hidden" name="command" value="logout" />
                    <input type="submit" value="Log Out" />
                </form>
            </div>
        </div>
        <div id="usertypeelem">${String.valueOf(user.getUserType())}</div>
    </body>
</html>