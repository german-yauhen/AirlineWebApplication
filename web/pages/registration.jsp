<%--Created by Yauheni Hermanovich 14.07.2017--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
    <head>
        <title>Registration Page</title>
        <style type="text/css">
            body {
                margin: 0px;
                padding: 0px;
                display: inline-block;
                background: url("/images/bg_menu.jpg") no-repeat center center fixed;
                background-size: cover;
            }
            .buttons {
                display: flex;
                justify-content: space-between;
                text-align: justify;
                text-align-last: justify;
            }
            .buttomsitem {
                display: inline-block;
            }
            .itputelem {
                opacity: 0.7;
            }
            #registartionelem {
                position: absolute;
                left: 40%; top: 22%;
            }
            #registrationpageelem {
                position: fixed;
                left: 10px; bottom: 10px;
                color: firebrick;
            }
            #error {
                color: firebrick;
            }
        </style>
    </head>
    <body>
        <div id="registartionelem">
            <form name="registrationForm" method="POST" action="controller">
                <input type="hidden" name="command" value="registration"/>
                <fieldset>
                    <legend align="center">Registration Form</legend>
                    <table>
                        <tr>
                            <td>First Name:</td>
                            <td><input class="itputelem" type="text" name="firstName" value=""/></td>
                        </tr>
                        <tr>
                            <td>Surname:</td>
                            <td><input class="itputelem" type="text" name="surname" value=""/></td>
                        </tr>
                        <tr>
                            <td>Document Number:</td>
                            <td><input class="itputelem" type="text" name="documentNumber" value=""/></td>
                        </tr>
                        <tr>
                            <td>Login:</td>
                            <td><input class="itputelem" type="text" name="login" value=""/></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input class="itputelem" type="password" name="password" value=""/></td>
                        </tr>
                    </table>
                    <div class="buttons">
                        <input class="buttomsitem" type="submit" value="Register"/>
                        <input class="buttomsitem" type="reset" value="Reset"/>
                        ${pageContext.session.setAttribute("backpage", "login")}
                        <input type="button" value="Back" onclick='location.href="controller?command=back"'/>
                    </div>
                </fieldset>
                <h4 id="error">${operationMessage}</h4>
            </form>
        </div>
        <div id="registrationpageelem">REGISTRATION PAGE</div>
    </body>
</html>
