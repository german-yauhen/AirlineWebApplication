<%--Created by Yauheni Hermanovich 21.07.2017--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="spec"%>
<html>
    <head>
        <title>Flights</title>
        <link rel="stylesheet" type="text/css" href="/css/flightsMain.css"/>
    </head>
    <body>
    <div class="wrapperWelcomeInfo">
        <div class="welcomeElement">
            <i>${user.getFirstName()} ${user.getSurname()}.</i>
        </div>
    </div>
        <div class="wrapperPageData">
            <div class="resultFlightForm">
                <form name="flightSearchResults">
                    <fieldset>
                        <legend align="left">Search Results</legend>
                        <input type="hidden" name="command" value="createticket"/>
                        <div class="resultTableContents">
                            <table>
                                <tr>
                                    <th>Flight Number</th>
                                    <th>Departure Airport</th>
                                    <th>Arrival Airport</th>
                                    <th>Departure Date</th>
                                    <th>Price</th>
                                    <th>Choose</th>
                                </tr>
                                <spec:forEach var="flight" items="${flightsList}">
                                    <tr>
                                        <td>${flight.getFlightNumber()}</td>
                                        <td>${flight.getDepartureAirport()}</td>
                                        <td>${flight.getArrivalAirport()}</td>
                                        <td>${String.valueOf(flight.getSheduledDeparture())}</td>
                                        <td>${flight.getPricePerSeat()}&#8364;</td>
                                        <td><input type="radio" name="flightInfo" value="${flight.getId()}"/></td>
                                    </tr>
                                </spec:forEach>
                            </table>
                        </div>
                        <div class="wrapperButtonsChooseFlight">
                            <div class="buttonElement">
                                <input type="hidden" name="cleintId" value="${user.getId()}"/>
                                <b><i>Choose Luggage: </i></b>
                                <select name="luggageForBooking">
                                    <spec:forEach var="luggage" items="${allLuggageTypes}">
                                        <option value="${luggage.getLuggageType()}">
                                                ${luggage.getLuggageType()} + ${luggage.getPrice()} &#8364;
                                        </option>
                                    </spec:forEach>
                                </select>
                            </div>
                            <input class="buttonElement" type="submit" value="Book Flight"/>
                            ${pageContext.session.setAttribute("backpage", "client")}
                            <input class="buttonElement" type="reset" value="Reset"/>
                            <input class="buttonElement" type="button" value="Back To Menu" onclick='location.href="controller?command=back"'/>
                        </div>
                    </fieldset>
                </form>
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
