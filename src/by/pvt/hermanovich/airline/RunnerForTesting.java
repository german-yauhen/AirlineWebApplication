package by.pvt.hermanovich.airline;

import by.pvt.hermanovich.airline.dao.implementations.AircraftDAO;
import by.pvt.hermanovich.airline.exceptions.DAOException;
import by.pvt.hermanovich.airline.utils.ConnectorDB;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Description:
 * Created by Yauheni Hermanovich on 10.07.2017.
 */
public class RunnerForTesting {
    private static final Logger logger = Logger.getLogger(RunnerForTesting.class);

    public static void main(String[] args) {
        logger.info("Begin.");
        Connection connection = null;
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            connection = ConnectorDB.getConnection();
            logger.info(connection.getMetaData().getURL());
            logger.info(connection.getMetaData().getUserName());
            logger.info("Transaction isolation level is " + String.valueOf(connection.getTransactionIsolation()));
            logger.info("Supporting save points is " + connection.getMetaData().supportsSavepoints());
            try {
//                User user = UserDAO.getInstance().getById(7, connection);
//                user.setFirstName("Edmont");
//                user.setSurname("Dantes");
//                user.setDocumentNumber("MK1239875");
//                user.setLogin("montecristo");
//                user.setPassword("graf");
//                user.setUserType(UserType.CLIENT);
//                UserDAO.getInstance().update(user, connection);
//                logger.info("Logged? - " + String.valueOf(
//                        UserDAO.getInstance().isAuthorized("german", "123", connection)
//                ));
//                Airport airport = new Airport("WWW", "WWWAIRWWW", "AIRCITY");
//                AirportDAO.getInstance().add(airport, connection);
//                AirportDAO.getInstance().deleteByCode("WWW", connection);
//                AirportDAO.getInstance().getByCode("VNO", connection);
//                logger.info(AirportDAO.getInstance().getByCode("VNO", connection));
//                logger.info(UserDAO.getInstance().getAll(connection));
//                AirportDAO.getInstance().getAll(connection);
//                AirportDAO.getInstance().getAll(connection);
//                UserDAO.getInstance().getAll(connection);
//                Luggage cabinNew = LuggageDAO.getInstance().getById(3, connection);
//                cabinNew.setLuggageType("baggage");
//                cabinNew.setPrice((float)18.0);
//                LuggageDAO.getInstance().update(cabinNew, connection);
//                logger.info(LuggageDAO.getInstance().getById(3, connection));
//                LuggageDAO.getInstance().deleteById(3, connection);
//                AircraftDAO.getInstance().getByCode("EI-SEV", connection);
//                Aircraft aircraft = new Aircraft("NEW-AIR", "Samalet EPTA");
//                AircraftDAO.getInstance().add(aircraft, connection);
//                Aircraft aircraftNew = AircraftDAO.getInstance().getByCode("EI-SEV", connection);
//                aircraftNew.setModel("Boeing 737-700");
//                AircraftDAO.getInstance().update(aircraftNew, connection);
                AircraftDAO.getInstance().getAll(connection);
//                AircraftDAO.getInstance().deleteAircraftByCode("NEW-AIR", connection);
                logger.info("DONE!");
            } catch (DAOException daoException) {
                logger.error(daoException);
            }
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            ConnectorDB.closeConnection(connection);
            logger.info("Connection has been closed successfully.");
        }
        logger.info("End.");
    }
}