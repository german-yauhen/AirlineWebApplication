package by.pvt.hermanovich.airline.utils.controllerUtils;

import by.pvt.hermanovich.airline.commands.BasicCommand;
import by.pvt.hermanovich.airline.commands.factory.CommandsFactory;
import by.pvt.hermanovich.airline.constants.MessageConstants;
import by.pvt.hermanovich.airline.constants.Parameters;
import by.pvt.hermanovich.airline.managers.ConfigManagerMessages;
import by.pvt.hermanovich.airline.managers.ConfigManagerPages;
import by.pvt.hermanovich.airline.constants.PathPageConstants;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: This class contains method that handles a request from a *.jsp page.
 *
 * Created by Yauheni Hermanovich on 14.07.2017.
 */
public class RequestHandler extends HttpServlet {

    public RequestHandler() {
    }

    /**
     * This method defines a command from request that will be executed.
     * This method follows the next steps:
     *      - defines the command that received from a *.jsp page;
     *      - calls the implemented <i>execute()</i> method and passes parameters to the handler class,
     *          which is related to a particular command;
     *      - redirects to the required page, it also might be an error page if the required page are not found.
     *
     * @param request       - an object of request from a client.
     * @param response      - an object of response from Controller.
     * @throws ServletException
     * @throws IOException
     */
    public static void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandsFactory factory = CommandsFactory.getInstance();
        BasicCommand command = factory.defineCommand(request);
        String page = command.execute(request);
        if (page != null) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.INDEX_PAGE);
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}