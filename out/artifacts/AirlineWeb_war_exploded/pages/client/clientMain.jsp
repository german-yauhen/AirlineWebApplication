<%--Created by Yauheni Hermanovich 14.07.2017--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="spec"%>
<html>
    <head>
        <title>Clients account page</title>
        <link rel="stylesheet" type="text/css" href="/css/clientMain.css" />
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
            <div class="luggageForm">
                <form name="updateLuggage" method="POST" action="controller">
                    <fieldset>
                        <legend align="center">Update Luggage</legend>
                        <input type="hidden" name="command" value="updateluggage"/>
                        <table>
                            <tr>
                                <td>Type:</td>
                                <td>
                                    <select name="luggageTypeToUpdate">
                                        <option selected="selected" disabled>Choose Type</option>
                                        <spec:forEach var="luggage" items="${allLuggageTypes}">
                                            <option value="${luggage.getLuggageType()}">${luggage.getLuggageType()}</option>
                                        </spec:forEach>
                                    </select>
                                </td>
                            </tr>
                        </table>
                        <div class="wrapperButtons">
                            <input class="buttonElement" type="submit" value="Update"/>
                            <input class="buttonElement" type="reset" value="Reset"/>
                            <input type="button" value="Delete" onclick='location.href="controller?command=deleteluggage"'/>
                        </div>
                    </fieldset>
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