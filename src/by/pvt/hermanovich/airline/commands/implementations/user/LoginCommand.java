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
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Description: This class describes actions of logon logic.
 *
 * Created by Yauheni Hermanovich on 14.07.2017.
 */
public class LoginCommand implements BasicCommand {
    private final static Logger logger = Logger.getLogger(LoginCommand.class);

    /**
     * This method describes the logon logic.
     *
     * @param request - request which will be processed.
     * @return - a page which user will be directed to.
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
                        page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.ADMIN_PAGE);
                        break;
                    case CLIENT:
                        page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.CLIENT_PAGE);
                        break;
                    default:
                        page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.CLIENT_PAGE);
                        break;
                }
                logger.info(MessageConstants.SUCCESS_LOGIN);
            } else {
                page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.INDEX_PAGE);
                request.setAttribute(Parameters.ERROR_LOGIN_PASSWORD, MessageConstants.WRONG_LOGIN_OR_PASSWORD);
            }
        } catch (SQLException e) {
            page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.ERROR_PAGE);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageConstants.DATABASE_ACCESS_ERROR);
            logger.error(MessageConstants.DATABASE_ACCESS_ERROR);
        }
        return page;
    }
}
