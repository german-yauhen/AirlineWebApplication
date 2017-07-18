<%--Created by Yauheni Hermanovich 14.07.2017--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="spec"%>
<html>
    <head>
        <title>Administration Page</title>
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
            .data {
                position: fixed;
                left: 15px;
            }
            .itputelem {
                opacity: 0.7;
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
            .luggageelem {
                position: absolute;
                left: 25px; top: 280px;
            }
            .message {
                color: firebrick;
                font-weight: 600;
            }
            #newluggageelem {
                position: absolute;
                left: 0px; top: 0px;
            }
            #updluggageelem {
                position: absolute;
                left: 230px; top: 0px;
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
                left: 25px; top: 80px;
            }
        </style>
    </head>
    <body>
        <div class="data">
            <h3>
                Administration service of Airline Company.<br/>
                Administrator <i>${user.getFirstName()} ${user.getSurname()}</i>.
            </h3>
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
                        <i>You have successfully updated you personal data. Log in again to your account to see the changes.</i>
                    </spec:if>
                </form>
            </div>
            <!--NEW LUGGAGE--->
            <div class="luggageelem">
                <div id="newluggageelem">
                    <form name="createLuggage" method="POST" action="controller">
                        <fieldset>
                            <legend align="center">Add Luggage</legend>
                            <input type="hidden" name="command" value="createluggage">
                            <table>
                                <tr>
                                    <td>Type:</td>
                                    <td><input class="itputelem" type="text" name="luggageType" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Price:</td>
                                    <td><input class="itputelem" type="text" name="luggagePrice" /></td>
                                </tr>
                            </table>
                            <div class="buttons">
                                <input class="buttomsitem" type="submit" value="Create" />
                                <input class="buttomsitem" type="reset" value="Reset" />
                            </div>
                        </fieldset>
                        <div class="message">
                            <spec:if test="${sessionScope.luggageAddSuccess eq 'true'}">
                                <i>Luggage has been created. Log in again to your account to see the changes.</i>
                            </spec:if>
                        </div>
                    </form>
                </div>
                <!--UPD LUGGAGE-->
                <div id="updluggageelem">
                    <form name="updateLuggage" method="POST" action="controller">
                        <fieldset>
                            <legend align="center">Update Luggage</legend>
                            <input type="hidden" name="command" value="updateluggage">
                            <table>
                                <tr>
                                    <td>Type:</td>
                                    <td>
                                        <select name="luggageType">
                                            <option selected="selected" disabled>Choose Type</option>
                                            <spec:forEach var="luggage" items="${allLuggageTypes}">
                                                <option>${luggage.getLuggageType()}</option>
                                                <spec:set var="luggageTypeToUpdate" value="${luggage.getLuggageType()}" scope="session"/>
                                            </spec:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Price:</td>
                                    <td><input class="itputelem" type="text" name="luggagePrice"/></td>
                                </tr>
                            </table>
                            <div class="buttons">
                                <input class="buttomsitem" type="submit" value="Update" />
                                <input class="buttomsitem" type="reset" value="Reset" />
                                <input type="button" value="Delete" onclick='location.href="controller?command=deleteluggage"'/>
                            </div>
                        </fieldset>
                        <div class="message">
                            <spec:if test="${sessionScope.luggageDeleteSuccess eq 'true'}">
                                <i>Luggage has been deleted. Log in again to your account to see the changes.</i>
                            </spec:if>
                            <spec:if test="${sessionScope.luggageUpdateSuccess eq 'true'}">
                                <i>Luggage has been updated.</i>
                            </spec:if>
                        </div>
                    </form>
                </div>
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