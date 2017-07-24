package by.pvt.hermanovich.airline.commands.implementations.ticket;

import by.pvt.hermanovich.airline.commands.BasicCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: This class describes actions to return (remove) an user's ticket.
 *
 * Created by Yauheni Hermanovich on 24.07.2017.
 */
public class ReturnTicketCommand implements BasicCommand {

    /**
     * This method removes an user's ticket from the database table.
     *
     * @param request       - request which will be processed.
     * @return              - a page which user will be directed to.
     */
    @Override
    public String execute(HttpServletRequest request) {
        // TODO: 24.07.2017 DESCRIBE!!!
        return null;
    }
}