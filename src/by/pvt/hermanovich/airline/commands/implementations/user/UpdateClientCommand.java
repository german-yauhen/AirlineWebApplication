package by.pvt.hermanovich.airline.commands.implementations.user;

import by.pvt.hermanovich.airline.commands.BasicCommand;
import by.pvt.hermanovich.airline.constants.MessageConstants;
import by.pvt.hermanovich.airline.constants.Parameters;
import by.pvt.hermanovich.airline.constants.PathPageConstants;
import by.pvt.hermanovich.airline.dao.services.UserService;
import by.pvt.hermanovich.airline.entities.User;
import by.pvt.hermanovich.airline.managers.ConfigManagerPages;
import by.pvt.hermanovich.airline.utils.controllerUtils.RequestParameterIdentifier;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Description: This describes actions of update information about user.
 *
 * Created by Yauheni Hermanovich on 14.07.2017.
 */
public class UpdateClientCommand implements BasicCommand {
    private final static Logger logger = Logger.getLogger(UpdateClientCommand.class);

    /**
     * This method describes actions of update information about user.
     *
     * @param request - request which will be processed.
     * @return - a page which user will be directed to.
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        User user = RequestParameterIdentifier.getUserLoginPasswordFromRequest(request);
        try {
            user = UserService.getInstance().getUserByLogin(user.getLogin());
            user = RequestParameterIdentifier.getUserFromRequest(user, request);
            UserService.getInstance().updateUser(user);
            request.getSession().setAttribute(Parameters.SUCCESS_UPDATE, Parameters.TRUE);
            page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.CLIENT_PAGE);
        } catch (SQLException e) {
            page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.ERROR_PAGE);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageConstants.DATABASE_ACCESS_ERROR);
            logger.error(MessageConstants.DATABASE_ACCESS_ERROR);
        }
        return page;
    }
}
