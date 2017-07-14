package by.pvt.hermanovich.airline.utils.controllerUtils;

import by.pvt.hermanovich.airline.commands.factory.CommandType;
import by.pvt.hermanovich.airline.constants.Parameters;
import by.pvt.hermanovich.airline.entities.User;
import by.pvt.hermanovich.airline.entities.UserType;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: This class identifies request parameters.
 *
 * Created by Yauheni Hermanovich on 14.07.2017.
 */
public class RequestParameterIdentifier {

    /**
     * This method identifies a type command from request.
     *
     * @param request   - object of request.
     * @return          - type of command that will be executed.
     */
    public static CommandType getCommandFromRequest(HttpServletRequest request) {
        String commandFromRequest = request.getParameter(Parameters.COMMAND);
        CommandType commandType = CommandType.DEFAULT;
        if (commandFromRequest != null && (!commandFromRequest.isEmpty())) {
            commandType = CommandType.valueOf(commandFromRequest.toUpperCase());
        }
        return commandType;
    }

    /**
     * This method defines user type that can be client or admin.
     *
     * @param request   - object of request.
     * @return          - user type: client or admin.
     */
    public static UserType getUserType(HttpServletRequest request) {
        switch (String.valueOf(request.getSession().getAttribute(Parameters.USER_TYPE))) {
            case "client":
                return UserType.CLIENT;
            case "admin":
                return UserType.ADMIN;
            default:
                return UserType.CLIENT;
        }
    }
}
