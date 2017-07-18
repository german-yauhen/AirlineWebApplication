package by.pvt.hermanovich.airline.commands.implementations.user;

import by.pvt.hermanovich.airline.commands.BasicCommand;
import by.pvt.hermanovich.airline.commands.implementations.aircraft.ShowAllAircraftsCommand;
import by.pvt.hermanovich.airline.commands.implementations.airport.ShowAllAirportsCommand;
import by.pvt.hermanovich.airline.commands.implementations.luggage.ShowAllLuggageCommand;
import by.pvt.hermanovich.airline.constants.MessageConstants;
import by.pvt.hermanovich.airline.constants.Parameters;
import by.pvt.hermanovich.airline.constants.PathPageConstants;
import by.pvt.hermanovich.airline.dao.services.UserService;
import by.pvt.hermanovich.airline.entities.Aircraft;
import by.pvt.hermanovich.airline.entities.Airport;
import by.pvt.hermanovich.airline.entities.Luggage;
import by.pvt.hermanovich.airline.entities.User;
import by.pvt.hermanovich.airline.managers.ConfigManagerPages;
import by.pvt.hermanovich.airline.utils.controllerUtils.RequestParameterIdentifier;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Description: This class describes actions of logon logic.
 *
 * Created by Yauheni Hermanovich on 14.07.2017.
 */
public class LoginCommand implements BasicCommand {
    private final static Logger logger = Logger.getLogger(LoginCommand.class);

    /**
     * This method describes the logon logic. The method uses methods of the RequestParameterIdentifier and UserService
     * classes and works according to the following steps:
     *      - getting an user object from request object using login and password saved in the corresponding request
     *      object using the <i>getUserLoginPasswordFromRequest(...)<i/> method;
     *      - checking user's authorization using the <i>checkUserAuthorization(...)</i> method;
     *      - if the user is authorized the user's are created using the <i>getUserByLogin(...)<i/> method;
     *      - generating the page according to the user's type (client or admin).
     *
     * @param request   - request which will be processed.
     * @return          - a page which user will be directed to.
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        User user = RequestParameterIdentifier.getUserLoginPasswordFromRequest(request);
        HttpSession session = request.getSession();
        try {
            if (UserService.getInstance().checkUserAuthorization(user.getLogin(), user.getPassword())) {
                user = UserService.getInstance().getUserByLogin(user.getLogin());
                session.setAttribute(Parameters.USER, user);
                session.setAttribute(Parameters.USER_TYPE, String.valueOf(user.getUserType()));
                switch (user.getUserType()) {
                    case ADMIN:
                        // TODO: 17.07.2017 method() that returns lists of luggage, aircrafts ... to the admins page
                        // TODO: 17.07.2017 session.setAttribute(this parameters)
                        List<Luggage> allLuggageTypes = ShowAllLuggageCommand.getAllLuggage();
                        session.setAttribute(Parameters.ALL_LUGGAGE_TYPES, allLuggageTypes);
                        List<Airport> airportList = ShowAllAirportsCommand.getAllAirports();
                        session.setAttribute(Parameters.ALL_AIRPORTS, airportList);
                        List<Aircraft> aircraftList = ShowAllAircraftsCommand.getAllAircrafts();
                        session.setAttribute(Parameters.ALL_AIRCRAFTS, aircraftList);
                        page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.ADMIN_PAGE_PATH);
                        break;
                    case CLIENT:
                        page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.CLIENT_PAGE_PATH);
                        break;
                    default:
                        page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.CLIENT_PAGE_PATH);
                        break;
                }
                logger.info(MessageConstants.SUCCESS_LOGIN);
            } else {
                page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.INDEX_PAGE_PATH);
                request.setAttribute(Parameters.ERROR_LOGIN_PASSWORD, MessageConstants.WRONG_LOGIN_OR_PASSWORD);
            }
        } catch (SQLException e) {
            page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageConstants.DATABASE_ACCESS_ERROR);
            logger.error(MessageConstants.DATABASE_ACCESS_ERROR);
        }
        return page;
    }
}
