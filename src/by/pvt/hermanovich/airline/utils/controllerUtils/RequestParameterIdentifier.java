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
        CommandType commandType = CommandType.DEFAULT;
        if (request.getParameter(Parameters.COMMAND) != null
                && !request.getParameter(Parameters.COMMAND).isEmpty()) {
            commandType = CommandType.valueOf(request.getParameter(Parameters.COMMAND).toUpperCase());
        }
        return commandType;
    }


    /**
     * This method defines user type from request.
     *
     * @param request   - object of request.
     * @return          - user type; it can be client or admin.
     */
    public static UserType getUserTypeFromRequest(HttpServletRequest request) {
        switch (String.valueOf(request.getSession().getAttribute(Parameters.USER_TYPE))) {
            case "client":
                return UserType.CLIENT;
            case "admin":
                return UserType.ADMIN;
            default:
                return UserType.CLIENT;
        }
    }

    /**
     * This method receives users login and password from an object of request
     * and constructs an user with the corresponding fields.
     *
     * @param request   - object of request.
     * @return          - an user with the following fields: login and password.
     */
    public static User getUserLoginPasswordFromRequest(HttpServletRequest request) {
        User user = new User();
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);
        if (login != null && !login.isEmpty()) {
            user.setLogin(login);
        }
        if (password != null && !password.isEmpty()) {
            user.setPassword(password);
        }
        return user;
    }

    /**
     * This method receives first name, surname, document number from request
     * and sets this values to the corresponding fields of the user which is passed
     * to the method as parameter.
     *
     * @param user      - user, which fields will be updated.
     * @param request   - request object with necessaries parameters.
     * @return          - user object with updated fields.
     */
    public static User getUserFromRequest(User user, HttpServletRequest request) {
        String firstName = request.getParameter(Parameters.FIRST_NAME);
        String surname = request.getParameter(Parameters.SURNAME);
        String documentNumber = request.getParameter(Parameters.DOCUMENT_NUMBER);
        String login = request.getParameter(Parameters.LOGIN);
        if ( (firstName != null && !firstName.isEmpty())
                & (surname != null && !surname.isEmpty())
                & (documentNumber != null && !documentNumber.isEmpty())
                & (login != null && !login.isEmpty())) {
            user.setFirstName(firstName);
            user.setSurname(surname);
            user.setDocumentNumber(documentNumber);
        }
        return user;
    }
}
