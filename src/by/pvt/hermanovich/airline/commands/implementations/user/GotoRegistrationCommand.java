package by.pvt.hermanovich.airline.commands.implementations.user;

import by.pvt.hermanovich.airline.commands.BasicCommand;
import by.pvt.hermanovich.airline.constants.PathPageConstants;
import by.pvt.hermanovich.airline.managers.ConfigManagerPages;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: This class describes action to redirect guest to the registration page.
 * Created by Yauheni Hermanovich on 14.07.2017.
 */
public class GotoRegistrationCommand implements BasicCommand {

    /**
     * This method describes action to redirect guest to the registration page.
     *
     * @param request   - request which will be processed.
     * @return          - a page which user will be directed to.
     */
    @Override
    public String execute(HttpServletRequest request) {
        return ConfigManagerPages.getInstance().getProperty(PathPageConstants.REGISTRATION);
    }
}
