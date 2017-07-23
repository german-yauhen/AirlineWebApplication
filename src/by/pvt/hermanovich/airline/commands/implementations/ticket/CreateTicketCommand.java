package by.pvt.hermanovich.airline.commands.implementations.ticket;

import by.pvt.hermanovich.airline.commands.BasicCommand;
import by.pvt.hermanovich.airline.dao.services.TicketService;
import by.pvt.hermanovich.airline.entities.Ticket;
import by.pvt.hermanovich.airline.utils.controllerUtils.RequestParameterIdentifier;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Description: This class describes actions to create ticket for client of the airline company.
 *
 * Created by Yauheni Hermanovich on 21.07.2017.
 */
public class CreateTicketCommand implements BasicCommand {
    private static final Logger logger = Logger.getLogger(CreateTicketCommand.class);

    /**
     * The method describes workflow of the actions to create the ticket to the flight.
     *
     * @param request - request which will be processed.
     * @return - a page which user will be directed to.
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        Ticket ticket = null;
        HashMap<String, String> ticketInfoMap = new HashMap<>();
        // TODO: 23.07.2017 REFACTORING: map with Integer keys; {user.getId()} put in the jsp and in the request
        ticketInfoMap = RequestParameterIdentifier.getTicketInfoFromRequest(ticketInfoMap, request);
        try {
            ticket = TicketService.getInstance().createTicketFromInfoMap(ticketInfoMap);
        } catch (SQLException e) {

        }
        return page;
    }
}
