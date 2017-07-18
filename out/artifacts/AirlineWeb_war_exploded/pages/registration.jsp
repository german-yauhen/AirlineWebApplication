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
            .wrapperButtons {
                display: flex;
                justify-content: space-between;
                text-align: justify;
                text-align-last: justify;
            }
            .buttonElement {
                display: inline-block;
            }
            .inputElement {
                opacity: 0.7;
            }
            .registrationForm {
                position: absolute;
                left: 40%; top: 22%;
            }
            .operationMessageElement {
                position: fixed;
                left: 10px; bottom: 5px;
                color: firebrick;
            }
            .registrationPageMessage {
                position: fixed;
                left: 10px; bottom: 5px;
                color: firebrick;
            }
        </style>
    </head>
    <body>
        <div class="registrationForm">
            <form name="registrationForm" method="POST" action="controller">
                <input type="hidden" name="command" value="registration"/>
                <fieldset>
                    <legend align="center">Registration Form</legend>
                    <table>
                        <tr>
                            <td>Name:</td>
                            <td><input class="inputElement" type="text" name="firstName" value=""/></td>
                        </tr>
                        <tr>
                            <td>Surname:</td>
                            <td><input class="inputElement" type="text" name="surname" value=""/></td>
                        </tr>
                        <tr>
                            <td>Document:</td>
                            <td><input class="inputElement" type="text" name="documentNumber" value=""/></td>
                        </tr>
                        <tr>
                            <td>Login:</td>
                            <td><input class="inputElement" type="text" name="login" value=""/></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input class="inputElement" type="password" name="password" value=""/></td>
                        </tr>
                    </table>
                    <div class="wrapperButtons">
                        <input class="buttonElement" type="submit" value="Register"/>
                        <input class="buttonElement" type="reset" value="Reset"/>
                        ${pageContext.session.setAttribute("backpage", "login")}
                        <input type="button" value="Back" onclick='location.href="controller?command=back"'/>
                    </div>
                </fieldset>
                <div class="operationMessageElement">
                    </br>${operationMessage}
                </div>
            </form>
        </div>
        <div class="registrationPageMessage">REGISTRATION PAGE</div>
    </body>
</html>
