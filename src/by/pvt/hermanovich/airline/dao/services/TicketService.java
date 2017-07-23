package by.pvt.hermanovich.airline.dao.services;

import by.pvt.hermanovich.airline.constants.MessageConstants;
import by.pvt.hermanovich.airline.constants.Parameters;
import by.pvt.hermanovich.airline.entities.Flight;
import by.pvt.hermanovich.airline.entities.Luggage;
import by.pvt.hermanovich.airline.entities.Ticket;
import by.pvt.hermanovich.airline.entities.User;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Description: This class describes actions on the ticket object.
 *
 * Created by Yauheni Hermanovich on 23.07.2017.
 */
public class TicketService {
    private final static Logger logger = Logger.getLogger(FlightService.class);

    private volatile static TicketService instance;

    public TicketService() {
    }

    /**
     * Singleton realization with "Double Checked Locking & Volatile" principle for high performance and thread safety.
     *
     * @return      - an instance of the class.
     */
    public static TicketService getInstance() {
        if (instance == null) {
            synchronized (TicketService.class) {
                if (instance == null) {
                    return instance = new TicketService();
                }
            }
        }
        return instance;
    }

    /**
     * This method create a new entity of ticket from a <i>map</i> of parameters.
     * The map is passed the the method as a parameter. The method invokes and directs
     * the control to other service classes of this module:
     *      - UserService
     *      - FlightService
     *      - LuggageService
     *
     * @param ticketInfoMap     - a map with parameters.
     * @return                  - an entity of ticket.
     * @throws SQLException
     */
    public Ticket createTicketFromInfoMap(HashMap<String, String> ticketInfoMap) throws SQLException {
        Ticket ticket = new Ticket();
        User user = null;
        Flight flight = null;
        Luggage luggage = null;
        try {
            user = UserService.getInstance().getUserByLogin(ticketInfoMap.get(Parameters.LOGIN));
            flight = FlightService.getInstance().getFlightById(Integer.parseInt(ticketInfoMap.get(Parameters.FLIGHT_ID)));
            luggage = LuggageService.getInstance().getLuggageById(Integer.parseInt(ticketInfoMap.get(Parameters.LUGGAGE_ID)));
            // TODO: 23.07.2017 CONTINUE
        } catch (SQLException e) {
            logger.error(MessageConstants.DATABASE_ACCESS_ERROR);
            throw new SQLException(MessageConstants.DATABASE_ACCESS_ERROR, e);
        }
        return ticket;
    }
}