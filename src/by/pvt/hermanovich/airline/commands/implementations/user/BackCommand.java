package by.pvt.hermanovich.airline.commands.implementations.user;

import by.pvt.hermanovich.airline.commands.BasicCommand;
import by.pvt.hermanovich.airline.constants.Parameters;
import by.pvt.hermanovich.airline.constants.PathPageConstants;
import by.pvt.hermanovich.airline.managers.ConfigManagerPages;
import by.pvt.hermanovich.airline.utils.controllerUtils.RequestParameterIdentifier;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: This class describe action to "back" command.
 *
 * Created by Yauheni Hermanovich on 17.07.2017.
 */
public class BackCommand implements BasicCommand {

    /**
     * This method describes action to "back" command.
     *
     * @param request   - request which will be processed.
     * @return          - a page which user will be directed to.
     */
    @Override
    public String execute(HttpServletRequest request) {
        String pageFromRequest = RequestParameterIdentifier.getPageFromRequest(request);
        String page = null;
        if ( pageFromRequest != null && pageFromRequest.equals(Parameters.LOGIN) ) {
            return page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.LOGIN_PAGE_PATH);
        } else {
            return page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.CLIENT_PAGE_PATH);
        }
    }
}
