package by.pvt.hermanovich.airline.dao.implementations;

import by.pvt.hermanovich.airline.constants.MessageConstants;
import by.pvt.hermanovich.airline.constants.QueriesDB;
import by.pvt.hermanovich.airline.dao.ImplFlightDAO;
import by.pvt.hermanovich.airline.entities.Flight;
import by.pvt.hermanovich.airline.exceptions.DAOException;
import by.pvt.hermanovich.airline.utils.ConnectorDB;
import org.apache.log4j.Logger;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Description: This class contains implementation of interface methods which works with <i>flights</i> database table.
 *
 * Created by Yauheni Hermanovich on 19.07.2017.
 */
public class FlightDAO implements ImplFlightDAO {
    private static final Logger logger = Logger.getLogger(FlightDAO.class);

    private volatile static FlightDAO instance;

    private FlightDAO() {
    }

    /**
     * Singleton realization with "Double Checked Locking & Volatile" principle for high performance and thread safety.
     *
     * @return      - an instance of the class.
     */
    public static FlightDAO getInstance() {
        if (instance == null) {
            synchronized (FlightDAO.class) {
                if (instance == null) {
                    instance = new FlightDAO();
                }
            }
        }
        return instance;
    }

    /**
     * This method creates and inserts an entity in a database table.
     *
     * @param flight     - the current flight which has been created.
     * @param connection - the current connection to a database. Transmitted from the service module to provide transactions.
     */
    @Override
    public void add(Flight flight, Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(QueriesDB.ADD_FLIGHT);
            statement.setString(1, flight.getAircraft().getAircraftCode());
            statement.setString(2, flight.getFlightNumber());
            statement.setString(3, flight.getDepartureAirport().getAirportCode());
            statement.setString(4, flight.getArrivalAirport().getAirportCode());
            statement.setDate(5, flight.getSheduledDeparture());
            statement.setDate(6, flight.getSheduledArrival());
            statement.setFloat(7, flight.getPricePerSeat());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(MessageConstants.EXECUTE_QUERY_ERROR, e);
            throw new DAOException(MessageConstants.EXECUTE_QUERY_ERROR, e);
        } finally {
            ConnectorDB.closeStatement(statement);
        }
    }

    /**
     * This method updates an existing record (row) in a database table.
     *
     * @param flight     - the current flight which will be updated.
     * @param connection - the current connection to a database. Transmitted from the service module to provide transactions.
     */
    @Override
    public void update(Flight flight, Connection connection) throws DAOException {

    }

    /**
     * This method reads and returns information from all records (rows) of a database table.
     *
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return              - list of all flights from a database table.
     */
    @Override
    public List<Flight> getAll(Connection connection) throws DAOException {
        return null;
    }
}
