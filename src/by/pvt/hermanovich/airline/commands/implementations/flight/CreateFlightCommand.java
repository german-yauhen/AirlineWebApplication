package by.pvt.hermanovich.airline.commands.implementations.flight;

import by.pvt.hermanovich.airline.commands.BasicCommand;
import by.pvt.hermanovich.airline.constants.MessageConstants;
import by.pvt.hermanovich.airline.constants.Parameters;
import by.pvt.hermanovich.airline.constants.PathPageConstants;
import by.pvt.hermanovich.airline.dao.services.FlightService;
import by.pvt.hermanovich.airline.entities.Flight;
import by.pvt.hermanovich.airline.managers.ConfigManagerPages;
import by.pvt.hermanovich.airline.utils.controllerUtils.RequestParameterIdentifier;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Description: This class describes actions to create flight by an administrator of the application.
 *
 * Created by Yauheni Hermanovich on 19.07.2017.
 */
public class CreateFlightCommand implements BasicCommand {
    private static final Logger logger = Logger.getLogger(CreateFlightCommand.class);

    /**
     * This method describes actions to create flight.
     *
     * @param request - request which will be processed.
     * @return - a page which user will be directed to.
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        Flight flight = null;
        HashMap<String, String> flightInfoMap = RequestParameterIdentifier.getFlightInfoFromRequest(request);
        try {
            flight = FlightService.getInstance().buildFlightFromMap(flightInfoMap);
            FlightService.getInstance().addFlightToDB(flight);
            request.getSession().setAttribute(Parameters.FLIGHT_REGISTER_SUCCESS, Parameters.TRUE);
            page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.ADMIN_PAGE_PATH);
        } catch (SQLException e) {
            page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageConstants.DATABASE_ACCESS_ERROR);
            logger.error(MessageConstants.DATABASE_ACCESS_ERROR);
        }
        return page;
    }
}