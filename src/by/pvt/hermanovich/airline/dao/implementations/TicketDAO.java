package by.pvt.hermanovich.airline.dao.implementations;

import by.pvt.hermanovich.airline.constants.MessageConstants;
import by.pvt.hermanovich.airline.constants.QueriesDB;
import by.pvt.hermanovich.airline.dao.ImplTicketDAO;
import by.pvt.hermanovich.airline.entities.Ticket;
import by.pvt.hermanovich.airline.exceptions.DAOException;
import by.pvt.hermanovich.airline.utils.ConnectorDB;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: This class contains implementation of interface methods which works with <i>tickets</i> database table.
 *
 * Created by Yauheni Hermanovich on 20.07.2017.
 */
public class TicketDAO implements ImplTicketDAO {
    private static final Logger logger = Logger.getLogger(TicketDAO.class);

    private volatile static TicketDAO instance;

    private TicketDAO() {
    }

    /**
     * Singleton realization with "Double Checked Locking & Volatile" principle for high performance and thread safety.
     *
     * @return      - an instance of the class.
     */
    public static TicketDAO getInstance() {
        if (instance == null) {
            synchronized (TicketDAO.class) {
                if (instance == null) {
                    instance = new TicketDAO();
                }
            }
        }
        return instance;
    }

    /**
     * This method creates and inserts an entity in a database table.
     *
     * @param ticket     - the current ticket which has been created.
     * @param connection - the current connection to a database. Transmitted from the service module to provide transactions.
     */
    @Override
    public void add(Ticket ticket, Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(QueriesDB.ADD_TICKET);
            statement.setString(1, ticket.getTicketNumber());
            statement.setInt(2, ticket.getUser().getId());
            statement.setInt(3, ticket.getFlight().getId());
            statement.setInt(4, ticket.getLuggage().getId());
            statement.setFloat(5, (ticket.getFlight().getPricePerSeat() + ticket.getLuggage().getPrice()));
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(MessageConstants.EXECUTE_QUERY_ERROR);
            throw new DAOException(MessageConstants.EXECUTE_QUERY_ERROR, e);
        } finally {
            ConnectorDB.closeStatement(statement);
        }
    }

    /**
     * This method updates an existing record (row) in a database table.
     *
     * @param ticket     - the current ticket which will be updated.
     * @param connection - the current connection to a database. Transmitted from the service module to provide transactions.
     */
    @Override
    public void update(Ticket ticket, Connection connection) throws DAOException {

    }

    /**
     * This method reads and returns information from all records (rows) of a database table.
     *
     * @param connection - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return - list of all tickets from a database table.
     */
    @Override
    public List<Ticket> getAll(Connection connection) throws DAOException {
        List<Ticket> ticketsList = new ArrayList<Ticket>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        // TODO: 21.07.2017 get resultSet and call the additional method to create an entity of ticket.
        try {
            statement = connection.prepareStatement(QueriesDB.GET_ALL_TICKETS);
            while (resultSet.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticketsList;
    }

    public Ticket createTicket(ResultSet resultSet, Connection connection) throws DAOException {
        Ticket ticket = new Ticket();
        // TODO: 21.07.2017 Build ticket logic
        return ticket;
    }
}
