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
                background: url("/images/bg_menu.jpg") no-repeat center center fixed;
                background-size: cover;
            }
            select {
                width: 100%;
            }
            .wrapperWelcomeInfo {
                position: absolute;
                left: 10px; top: 5px;
            }
            .welcomeElement {
                font-size: 18px;
            }
            .wrapperPageData {
                position: absolute;
                left: 10px; top: 50px;
            }
            .updateUserElement {
                position: absolute;
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
            .messageElement {
                color: firebrick;
                font-weight: 600;
            }
            .inputElement {
                opacity: 0.7;
            }
            .userTypeElement {
                position: fixed;
                left: 10px; bottom: 5px;
                color: firebrick;
            }
            .logoutElement {
                position: fixed;
                right: 10px; top: 10px;
            }
        </style>
    </head>
    <body>
        <div class="wrapperWelcomeInfo">
            <div class="welcomeElement">
                Welcome to Airline Company, <i>${user.getFirstName()} ${user.getSurname()}</i>!
            </div>
        </div>
        <div class="wrapperPageData">
            <!--UPDATE-->
            <div class="updateUserElement">
                <form name="clientData" method="POST" action="controller">
                    <fieldset>
                        <legend align="center">Update Form</legend>
                        <input type="hidden" name="command" value="updateclient"/>
                        <table>
                            <tr>
                                <td>Login:</td>
                                <td><input class="inputElement" type="text" name="login" value="${user.getLogin()}" readonly="readonly" /></td>
                            </tr>
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
                        </table>
                        <div class="wrapperButtons">
                            <input class="buttonElement" type="submit" value="Update"/>
                            <input class="buttonElement" type="reset" value="Reset"/>
                        </div>
                    </fieldset>
                    <div class="messageElement">
                        <spec:if test="${sessionScope.successUpdate eq 'true'}">
                            <i>You have successfully updated you personal data.</i>
                        </spec:if>
                    </div>
                </form>
            </div>
            <!--USER TYPE-->
            <div class="userTypeElement">
                </br>${String.valueOf(user.getUserType())}
            </div>
        </div>
        <!--LOGOUT-->
        <div class="logoutElement">
            <form name="logout" method="POST" action="controller">
                <input type="hidden" name="command" value="logout" />
                <input type="submit" value="Log Out" />
            </form>
        </div>
    </body>
</html>