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
            .wrapperLuggageForms {
                position: absolute;
                left: 255px; top: 0px;
            }
            .addLuggageForm {
                position: absolute;
                left: 0px; top: 0px;
            }
            .updateLuggageForm {
                position: absolute;
                left: 225px;
            }
            .wrapperAirportForms {
                position: absolute;
                left: 705px;
            }
            .addAirportForm {
                position: absolute;
                left: 0px;
            }
            .airportListForm {
                position: absolute;
                left: 230px;
                width: 250px;
            }
            .inputElement {
                opacity: 0.7;
            }
            .wrapperAircraftForms {
                position: absolute;
                top: 210px;
            }
            .addAircraftForm {
                position: absolute;
            }
            .aircraftListForm {
                position: absolute;
                left: 235px;
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
                Administration service of Airline Company.<br/>Administrator <i>${user.getFirstName()} ${user.getSurname()}</i>.
            </div>
        </div>
        <div class="wrapperPageData">
            <!--UPDATE-->
            <div class="updateUserElement">
                <form name="clientData" method="POST" action="controller">
                    <fieldset>
                        <legend align="center">Update Data Form</legend>
                        <input type="hidden" name="command" value="updateclient" />
                        <table>
                            <tr>
                                <td>Login:</td>
                                <td><input class="inputElement" type="text" name="login" value="${user.getLogin()}" readonly="readonly" /></td>
                            </tr>
                            <tr>
                                <td>Name:</td>
                                <td><input class="inputElement" type="text" name="firstName" value="" /></td>
                            </tr>
                            <tr>
                                <td>Surname:</td>
                                <td><input class="inputElement" type="text" name="surname" value="" /></td>
                            </tr>
                            <tr>
                                <td>Document:</td>
                                <td><input class="inputElement" type="text" name="documentNumber" value="" /></td>
                            </tr>
                        </table>
                        <div class="wrapperButtons">
                            <input class="buttonElement" type="submit" value="Update" />
                            <input class="buttonElement" type="reset" value="Reset" />
                        </div>
                    </fieldset>
                    <!--4-->
                </form>
            </div>
            <!--NEW LUGGAGE--->
            <div class="wrapperLuggageForms">
                <div class="addLuggageForm">
                    <form name="createLuggage" method="POST" action="controller">
                        <fieldset>
                            <legend align="center">Add Luggage</legend>
                            <input type="hidden" name="command" value="createluggage">
                            <table>
                                <tr>
                                    <td>Type:</td>
                                    <td><input class="inputElement" type="text" name="luggageType" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Price:</td>
                                    <td><input class="inputElement" type="text" name="luggagePrice" /></td>
                                </tr>
                            </table>
                            <div class="wrapperButtons">
                                <input class="buttonElement" type="submit" value="Create" />
                                <input class="buttonElement" type="reset" value="Reset" />
                            </div>
                        </fieldset>
                        <!--3-->
                    </form>
                </div>
                <!--UPD LUGGAGE-->
                <div class="updateLuggageForm">
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
                                    <td><input class="inputElement" type="text" name="luggagePrice"/></td>
                                </tr>
                            </table>
                            <div class="wrapperButtons">
                                <input class="buttonElement" type="submit" value="Update" />
                                <input class="buttonElement" type="reset" value="Reset" />
                                <input type="button" value="Delete" onclick='location.href="controller?command=deleteluggage"'/>
                            </div>
                        </fieldset>
                        <!--2-->
                    </form>
                </div>
            </div>
            <!--NEW AIRPORT-->
            <div class="wrapperAirportForms">
                <div class="addAirportForm">
                    <form name="Airport Data" method="POST" action="controller">
                        <fieldset>
                            <legend align="center">Add Airport</legend>
                            <input type="hidden" name="command" value="createairport" />
                            <table>
                                <tr>
                                    <td>Code:</td>
                                    <td><input class="inputElement" type="text" name="airportCode" value="WWW"/></td>
                                </tr>
                                <tr>
                                    <td>Name:</td>
                                    <td><input class="inputElement" type="text" name="airportName" value=""/></td>
                                </tr>
                                <tr>
                                    <td>City:</td>
                                    <td><input class="inputElement" type="text" name="airportCity" value=""/></td>
                                </tr>
                            </table>
                            <div class="wrapperButtons">
                                <input class="buttonElement" type="submit" value="Create" />
                                <input class="buttonElement" type="reset" value="Reset" />
                            </div>
                        </fieldset>
                        <!--1-->
                    </form>
                </div>
                <!--AIRPORTS LIST--->
                <div class="airportListForm">
                    <form name="airportList" style="width: 250px;">
                        <fieldset>
                            <legend align="center">Airports</legend>
                            <select name="airportObject" size=6 multiple style="opacity: 0.7">
                                <spec:forEach var="airport" items="${allAirports}">
                                    <option>[${airport.getAirportCode().toUpperCase()}]-[${airport.getAirportName().toUpperCase()}]-[${airport.getCity().toUpperCase()}]</option>
                                </spec:forEach>
                            </select>
                        </fieldset>
                    </form>
                </div>
            </div>
            <!--NEW AIRCRAFT-->
            <div class="wrapperAircraftForms">
                <div class="addAircraftForm">
                    <form name="Aircraft Data" method="POST" action="controller">
                        <fieldset>
                            <legend align="center">Add Aircraft</legend>
                            <input type="hidden" name="command" value="createaircraft" />
                            <table>
                                <tr>
                                    <td>Code:</td>
                                    <td><input class="inputElement" type="text" name="aircraftCode" value="WW-WWW"/></td>
                                </tr>
                                <tr>
                                    <td>Model:</td>
                                    <td><input class="inputElement" type="text" name="aircraftModel" value=""/></td>
                                </tr>
                            </table>
                            <div class="wrapperButtons">
                                <input class="buttonElement" type="submit" value="Create" />
                                <input class="buttonElement" type="reset" value="Reset" />
                            </div>
                        </fieldset>
                    </form>
                </div>
                <!--AIRCRAFTS LIST--->
                <div class="aircraftListForm">
                    <form name="aircraftList" style="width: 250px;">
                        <fieldset>
                            <legend align="center">Aircrafts</legend>
                            <select name="aircraftObject" size=5 multiple style="opacity: 0.8">
                                <spec:forEach var="aircraft" items="${allAircrafts}">
                                    <option>[${aircraft.getAircraftCode().toUpperCase()}]-[${aircraft.getModel().toUpperCase()}]</option>
                                </spec:forEach>
                            </select>
                        </fieldset>
                    </form>
                </div>
            </div>


            <!--USER TYPE-->
            <div class="userTypeElement">
                </br>${String.valueOf(user.getUserType())}
                <spec:if test="${sessionScope.airportUniqueError eq 'true'}">
                    <i> : MESSAGE : Airport with this code has already existed.</i>
                </spec:if>
                <spec:if test="${sessionScope.airportAddSuccess eq 'true'}">
                    <i> : MESSAGE : Airport has been created. Log in again to your account to see the changes.</i>
                </spec:if>
                <spec:if test="${sessionScope.luggageDeleteSuccess eq 'true'}">
                    <i> : MESSAGE : Luggage has been deleted. Log in again to your account to see the changes.</i>
                </spec:if>
                <spec:if test="${sessionScope.luggageUpdateSuccess eq 'true'}">
                    <i> : MESSAGE : Luggage has been updated. Log in again to your account to see the changes.</i>
                </spec:if>
                <spec:if test="${sessionScope.luggageAddSuccess eq 'true'}">
                    <i> : MESSAGE : Luggage has been created. Log in again to your account to see the changes.</i>
                </spec:if>
                <spec:if test="${sessionScope.successUpdate eq 'true'}">
                    <i> : MESSAGE : You have successfully updated your personal data. Log in again to your account to see the changes.</i>
                </spec:if>
                <spec:if test="${sessionScope.aircraftAddSuccess eq 'true'}">
                    <i> : MESSAGE : Aircraft has been created. Log in again to your account to see the changes.</i>
                </spec:if>
                <spec:if test="${sessionScope.aircraftUniqueError eq 'true'}">
                    <i> : MESSAGE : Aircraft with this code has already existed.</i>
                </spec:if>
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