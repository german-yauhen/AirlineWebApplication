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
            .data {
                position: fixed;
                left: 15px;
            }
            .itputelem {
                opacity: 0.5;
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
            #updateelem {
                position: absolute;
                left: 25px; top: 50px;
            }
        </style>
    </head>
    <body>
        <div class="data">
            <h3>Welcome to Airline Company, <i>${user.getFirstName()} ${user.getSurname()}</i>!</h3>
            <!--UPDATE-->
            <div id="updateelem">
                <form name="clientData" method="POST" action="controller">
                    <fieldset>
                        <legend align="center">Update Data Form</legend>
                        <input type="hidden" name="command" value="updateclient" />
                        <table>
                            <tr>
                                <td>Login:</td>
                                <td><input class="itputelem" type="text" name="login" value="${user.getLogin()}" readonly="readonly" /></td>
                            </tr>
                            <tr>
                                <td>First Name:</td>
                                <td><input class="itputelem" type="text" name="firstName" value="" /></td>
                            </tr>
                            <tr>
                                <td>Surname:</td>
                                <td><input class="itputelem" type="text" name="surname" value="" /></td>
                            </tr>
                            <tr>
                                <td>Document Number:</td>
                                <td><input class="itputelem" type="text" name="documentNumber" value="" /></td>
                            </tr>
                        </table>
                        <div class="buttons">
                            <input class="buttomsitem" type="submit" value="Update" />
                            <input class="buttomsitem" type="reset" value="Reset" />
                        </div>
                    </fieldset>
                    <spec:if test="${sessionScope.successUpdate eq 'true'}">
                        <i>You have successfully updated you personal data.</i>
                    </spec:if>
                </form>
            </div>
            <!--LOGOUT-->
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