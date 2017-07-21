package by.pvt.hermanovich.airline.dao.implementations;

import by.pvt.hermanovich.airline.constants.MessageConstants;
import by.pvt.hermanovich.airline.constants.Parameters;
import by.pvt.hermanovich.airline.constants.QueriesDB;
import by.pvt.hermanovich.airline.dao.ImplFlightDAO;
import by.pvt.hermanovich.airline.entities.Airport;
import by.pvt.hermanovich.airline.entities.Flight;
import by.pvt.hermanovich.airline.exceptions.DAOException;
import by.pvt.hermanovich.airline.utils.ConnectorDB;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
     * ***NOT USED***
     * This method updates an existing record (row) in a database table.
     *
     * @param entity     - the current entity which will be updated.
     * @param connection - the current connection to a database. Transmitted from the service module to provide transactions.
     */
    @Override
    public void update(Flight entity, Connection connection) throws DAOException {
    }

    /**
     * ***NOT USED***
     * This method reads and returns information from all records (rows) of a database table.
     *
     * @param connection - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return - list of all entities from a database table.
     */
    @Override
    public List<Flight> getAll(Connection connection) throws DAOException {
        return null;
    }

    /**
     * This method describes actions to find the flights by the departure airport, arrival airport and the date of the flight.
     *
     * @param depAirportForSearch   - departure airport for the search context;
     * @param arrAirportForSearch   - arrival airport for the search context;
     * @param dateForSearch         - date of flight for the search context;
     * @param connection            - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return                      - a list of flights that is fulfilled of the condition.
     * @throws DAOException
     */
    @Override
    public List<Flight> getFlightsByDepArrDate(Airport depAirportForSearch, Airport arrAirportForSearch, Date dateForSearch, Connection connection) throws DAOException {
        List<Flight> flightsFromDB = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(QueriesDB.GET_FLIGHTS_BY_DEP_ARR_DATE);
            statement.setString(1, depAirportForSearch.getAirportCode());
            statement.setString(2, arrAirportForSearch.getAirportCode());
            statement.setDate(3, dateForSearch);
            resultSet = statement.executeQuery();
            flightsFromDB = new ArrayList<Flight>();
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setId(resultSet.getInt(Parameters.ID));
                flight.setFlightNumber(resultSet.getString(Parameters.FLIGHT_NUMBER_DB));
                flight.setDepartureAirport(depAirportForSearch);
                flight.setArrivalAirport(arrAirportForSearch);
                flight.setSheduledDeparture(dateForSearch);
                flight.setSheduledArrival(dateForSearch);
                flight.setAircraft(AircraftDAO.getInstance().getByCode(resultSet.getString(Parameters.AIRCRAFTS_AIRCRAFT_CODE_DB), connection));
                flight.setPricePerSeat(resultSet.getFloat(Parameters.PRICE_PER_SEAT_DB));

                logger.info(flight.toString());

                flightsFromDB.add(flight);
            }
            logger.info(flightsFromDB.get(0));
            logger.info(flightsFromDB.get(1));
        } catch (SQLException e) {
            logger.error(MessageConstants.EXECUTE_QUERY_ERROR, e);
            throw new DAOException(MessageConstants.EXECUTE_QUERY_ERROR, e);
        } finally {
            ConnectorDB.closeResultSet(resultSet);
            ConnectorDB.closeStatement(statement);
        }
        return flightsFromDB;
    }

    /**
     * This method describes actions to find the flights by the departure and arrival airports of the flight.
     *
     * @param depAirportForSearch   - departure airport for the search context;
     * @param arrAirportForSearch   - arrival airport for the search context;
     * @param connection            - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return                      - a list of flights that is fulfilled of the condition.
     * @throws DAOException
     */
    @Override
    public List<Flight> getFlightsByDepArr(Airport depAirportForSearch, Airport arrAirportForSearch, Connection connection) throws DAOException {
        return null;
    }

    /**
     * This method describes actions to find the flights by the departure airport and the date of the flight.
     *
     * @param depAirportForSearch   - departure airport for the search context;
     * @param dateForSearch         - date of flight for the search context;
     * @param connection            - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return                      - a list of flights that is fulfilled of the condition.
     * @throws DAOException
     */
    @Override
    public List<Flight> getFlightsByDepDate(Airport depAirportForSearch, Date dateForSearch, Connection connection) throws DAOException {
        return null;
    }
}
