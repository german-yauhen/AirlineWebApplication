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
                background: url("/images/bg_registration.jpg") no-repeat center center fixed;
                background-size: cover;
            }
            .registraionform {
                position: absolute;
                top: 30%;
                left: 20%;
            }
        </style>
    </head>
    <body>
        <div class="registraionform">
            <p>Enter your <i>Personal Data</i> for registration.</p>
            <form name="registrationForm" method="POST" action="controller">
                <input type="hidden" name="command" value="registration"/>
                <fieldset style="width: 25%">
                    <legend align="center">Registration Form</legend>
                    <table>
                        <tr>
                            <td>First Name:</td>
                            <td><input type="text" name="firstName" value=""/></td>
                        </tr>
                        <tr>
                            <td>Surname:</td>
                            <td><input type="text" name="surname" value=""/></td>
                        </tr>
                        <tr>
                            <td>Document Number:</td>
                            <td><input type="text" name="documentNumber" value=""/></td>
                        </tr>
                        <tr>
                            <td>Login:</td>
                            <td><input type="text" name="login" value=""/></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="password" name="password" value=""/></td>
                        </tr>
                    </table>
                    <input type="submit" value="Registration"/>
                    <input type="reset" value="Reset"/>
                    <input type="button" value="Main Page" onclick='location.href="loginPage"'/>
                </fieldset>
            </form>
        </div>
    </body>
</html>
