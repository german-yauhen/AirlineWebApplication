package by.pvt.hermanovich.airline.commands.implementations.luggage;

import by.pvt.hermanovich.airline.commands.BasicCommand;
import by.pvt.hermanovich.airline.constants.MessageConstants;
import by.pvt.hermanovich.airline.constants.Parameters;
import by.pvt.hermanovich.airline.constants.PathPageConstants;
import by.pvt.hermanovich.airline.dao.services.LuggageService;
import by.pvt.hermanovich.airline.entities.Luggage;
import by.pvt.hermanovich.airline.managers.ConfigManagerPages;
import by.pvt.hermanovich.airline.utils.controllerUtils.RequestParameterIdentifier;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Description: This class describes operation of updating a luggage.
 *
 * Created by Yauheni Hermanovich on 17.07.2017.
 */
public class UpdateLuggageCommand implements BasicCommand {
    private static final Logger logger = Logger.getLogger(UpdateLuggageCommand.class);

    /**
     * This method describes update luggage logic.
     *
     * @param request - request which will be processed.
     * @return - a page which user will be directed to.
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        Luggage luggage = RequestParameterIdentifier.getLuggaggeToUpdate(request);
        try {
            luggage = LuggageService.getInstance().getLuggageFromDB(luggage);
            luggage = RequestParameterIdentifier.updateLuggageFromRequest(luggage, request);
            LuggageService.getInstance().updateLuggage(luggage);
            request.getSession().setAttribute(Parameters.LUGGAGE_UPDATE_SUCCESS, Parameters.TRUE);
            page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.ADMIN_PAGE_PATH);
        } catch (SQLException e) {
            page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageConstants.DATABASE_ACCESS_ERROR);
            logger.error(MessageConstants.DATABASE_ACCESS_ERROR);
        }
        return page;
    }
}
