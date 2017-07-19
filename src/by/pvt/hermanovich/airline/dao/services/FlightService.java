package by.pvt.hermanovich.airline.dao.services;

import by.pvt.hermanovich.airline.constants.MessageConstants;
import by.pvt.hermanovich.airline.constants.Parameters;
import by.pvt.hermanovich.airline.dao.implementations.FlightDAO;
import by.pvt.hermanovich.airline.entities.Aircraft;
import by.pvt.hermanovich.airline.entities.Airport;
import by.pvt.hermanovich.airline.entities.Flight;
import by.pvt.hermanovich.airline.exceptions.DAOException;
import by.pvt.hermanovich.airline.utils.ConnectorDB;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Description: This class describes actions on the flight object.
 *
 * Created by Yauheni Hermanovich on 19.07.2017.
 */
public class FlightService {
    private final static Logger logger = Logger.getLogger(FlightService.class);

    private volatile static FlightService instance;

    public FlightService() {
    }

    /**
     * Singleton realization with "Double Checked Locking & Volatile" principle for high performance and thread safety.
     *
     * @return      - an instance of the class.
     */
    public static FlightService getInstance() {
        if (instance == null) {
            synchronized (FlightService.class) {
                if (instance == null) {
                    return instance = new FlightService();
                }
            }
        }
        return instance;
    }

    /**
     * This method registers new flight of the airline company.
     * This method implements work with transaction support.
     *
     * @param flight   - a new flight object will be registered.
     * @throws SQLException
     */
    public void addFlightToDB(Flight flight) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectorDB.getConnection();
            connection.setAutoCommit(false);
            FlightDAO.getInstance().add(flight, connection);
            connection.commit();
            logger.info(MessageConstants.TRANSACTION_SUCCEEDED);
        } catch (SQLException | DAOException e) {
            if (connection != null) {
                connection.rollback();
            }
            logger.error(MessageConstants.TRANSACTION_FAILED);
            throw new SQLException(e);
        } finally {
            ConnectorDB.closeConnection(connection);
        }
    }

    /**
     * This method create a new entity of flight from a <i>map</i> of parameters.
     * The map is passed the the method as a parameter. The method invokes and directs
     * the control to other service classes of this module:
     *      - AircraftService
     *      - AirportService
     *      - AirportService
     *
     * @param flightParamMapFromRequest     - a map with parameters.
     * @return                              - an entity of flight.
     * @throws SQLException
     */
    public Flight createFlightFromRequestParameters(HashMap<String, String> flightParamMapFromRequest) throws SQLException {
        Flight flight = new Flight();
        Aircraft aircraftForFlight = null;
        Airport departureForFlight = null;
        Airport arrivalForFlight = null;
        try {
            aircraftForFlight =  AircraftService.getInstance().getAircraftFromDB(flightParamMapFromRequest.get(Parameters.AIRCRAFT_FOR_FLIGHT));
            departureForFlight = AirportService.getInstance().getAirportFromDB(flightParamMapFromRequest.get(Parameters.DEPARTURE_FOR_FLIGHT));
            arrivalForFlight = AirportService.getInstance().getAirportFromDB(flightParamMapFromRequest.get(Parameters.ARRIVAL_FOR_FLIGHT));
            if (aircraftForFlight != null && departureForFlight != null && arrivalForFlight != null) {
                flight.setAircraft(aircraftForFlight);
                flight.setFlightNumber(flightParamMapFromRequest.get(Parameters.FLIGHT_NUMBER_FOR_FLIGHT));
                flight.setDepartureAirport(departureForFlight);
                flight.setArrivalAirport(arrivalForFlight);
                flight.setSheduledDeparture(Date.valueOf(flightParamMapFromRequest.get(Parameters.DATE_OF_FLIGHT)));
                flight.setSheduledArrival(Date.valueOf(flightParamMapFromRequest.get(Parameters.DATE_OF_FLIGHT)));
                flight.setPricePerSeat(Float.parseFloat(flightParamMapFromRequest.get(Parameters.PRICE_PER_SEAT)));
            }
        } catch (SQLException e) {
            logger.error(MessageConstants.DATABASE_ACCESS_ERROR);
            throw new SQLException(MessageConstants.DATABASE_ACCESS_ERROR, e);
        }
        return  flight;
    }
}