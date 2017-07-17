package by.pvt.hermanovich.airline.utils.controllerUtils;

import by.pvt.hermanovich.airline.commands.factory.CommandType;
import by.pvt.hermanovich.airline.constants.Parameters;
import by.pvt.hermanovich.airline.entities.Luggage;
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
     * This method updates user's fields according to the requests parameters.
     * This method receives first name, surname, document number from request
     * and sets this values to the corresponding fields of the user which is passed
     * to the method as parameter.
     *
     * @param user      - user, which fields will be updated.
     * @param request   - request object with necessaries parameters.
     * @return          - user object with updated fields.
     */
    public static User updateUserFromRequest(User user, HttpServletRequest request) {
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

    /**
     * This method creates a new user of application. This method is used during registration operation.
     * This method receives first name, surname, document number, login and password from request
     * and sets this values to the corresponding fields of the user.
     *
     * @param request   - an object of request with necessary parameters.
     * @return          - user object with updated fields.
     */
    public static User getUserFromRequest(HttpServletRequest request) {
        User user = new User();
        String firstName = request.getParameter(Parameters.FIRST_NAME);
        String surname = request.getParameter(Parameters.SURNAME);
        String documentNumber = request.getParameter(Parameters.DOCUMENT_NUMBER);
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);
        if ( (firstName != null && !firstName.isEmpty())
                & (surname != null && !surname.isEmpty())
                & (documentNumber != null && !documentNumber.isEmpty())
                & (login != null && !login.isEmpty())
                & (password != null && !password.isEmpty()) ) {
            user.setFirstName(firstName);
            user.setSurname(surname);
            user.setDocumentNumber(documentNumber);
            user.setLogin(login);
            user.setPassword(password);
        }
        return user;
    }

    /**
     * This method receives a name of the page from the request.
     *
     * @param request   - request object with necessaries parameters.
     * @return          - a name of the page from request.
     */
    public static String getPageFromRequest(HttpServletRequest request) {
        String pageFromRequest = request.getSession().getAttribute(Parameters.BACK_PAGE).toString();
        request.getSession().removeAttribute(Parameters.BACK_PAGE);
        if (pageFromRequest != null && !pageFromRequest.isEmpty()) {
            return pageFromRequest;
        } else {
            return null;
        }
    }

    /**
     * This method checks if the fields of the form are filled.
     *
     * @param request   - an object of request with necessary parameters.
     * @return          - boolean value of the condition.
     */
    public static boolean areFieldsFilled(HttpServletRequest request) {
        boolean areFilled = false;
        if ( !request.getParameter(Parameters.LOGIN).isEmpty()
                && !request.getParameter(Parameters.PASSWORD).isEmpty()
                && !request.getParameter(Parameters.FIRST_NAME).isEmpty()
                && !request.getParameter(Parameters.SURNAME).isEmpty()
                && !request.getParameter(Parameters.DOCUMENT_NUMBER).isEmpty() ) {
            return areFilled = true;
        } else {
            return areFilled = false;
        }
    }

    /**
     * This method creates a new type of luggage for clients of airline company.
     *
     * @param request   - an object of request with necessary parameters.
     * @return          - a new type of luggage.
     */
    public static Luggage getLuggageFromRequest(HttpServletRequest request) {
        Luggage luggage = new Luggage();
        String luggageType = request.getParameter(Parameters.LUGGAGE_TYPE);
        String luggagePrice = request.getParameter(Parameters.LUGGAGE_PRICE);
        if ( luggageType != null && !luggageType.isEmpty()
                && luggagePrice != null && !luggagePrice.isEmpty() ) {
            luggage.setLuggageType(luggageType);
            luggage.setPrice(Float.parseFloat(luggagePrice));
        }
        return luggage;
    }
}
