package by.pvt.hermanovich.airline.commands.implementations.ticket;

import by.pvt.hermanovich.airline.commands.BasicCommand;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

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

        return page;
    }
}
