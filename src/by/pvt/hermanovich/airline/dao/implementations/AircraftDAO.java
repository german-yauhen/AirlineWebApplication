package by.pvt.hermanovich.airline.dao.implementations;

import by.pvt.hermanovich.airline.constants.QueriesDB;
import by.pvt.hermanovich.airline.dao.ImplAircraftDAO;
import by.pvt.hermanovich.airline.entities.Aircraft;
import by.pvt.hermanovich.airline.exceptions.DAOExceptiion;
import by.pvt.hermanovich.airline.utils.ConnectorDB;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Description: This class contains implementation of interface methods which works with <i>aircrafts</i> database table.
 * Created by Yauheni Hermanovich on 13.07.2017.
 */
public class AircraftDAO implements ImplAircraftDAO {
    private static final Logger logger = Logger.getLogger(Aircraft.class);

    private volatile static AircraftDAO instance;

    public AircraftDAO() {
    }

    /**
     * Singleton realization with "Double Checked Locking & Volatile" principle for high performance and thread safety.
     *
     * @return      - an instance of the class.
     */
    public static AircraftDAO getInstance() {
        if (instance == null) {
            synchronized (AircraftDAO.class) {
                if (instance == null) {
                    instance = new AircraftDAO();
                }
            }
        }
        return instance;
    }

    /**
     * This method creates and inserts an entity in a database table.
     *
     * @param aircraft      - the current entity which has been created.
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     */
    @Override
    public void add(Aircraft aircraft, Connection connection) throws DAOExceptiion {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(QueriesDB.ADD_AIRCRAFT);
            statement.setString(1, aircraft.getAircraftCode());
            statement.setString(2, aircraft.getModel());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "An error was occurred while executing the request to add the aircraft.";
            logger.error(message, e);
            throw new DAOExceptiion(message, e);
        } finally {
            ConnectorDB.closeStatement(statement);
        }
    }

    /**
     * This method updates an existing record (row) in a database table.
     *
     * @param aircraft      - the current entity which will be updated.
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     */
    @Override
    public void update(Aircraft aircraft, Connection connection) throws DAOExceptiion {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(QueriesDB.UPDATE_AIRCRAFT);
            statement.setString(1, aircraft.getModel());
            statement.setString(2, aircraft.getAircraftCode());
            statement.executeUpdate();
        } catch (SQLException e) {
            String message = "An error was occurred while executing the query to update the aircraft.";
            logger.error(message, e);
            throw new DAOExceptiion(message, e);
        } finally {
            ConnectorDB.closeStatement(statement);
        }
    }

    /**
     * This method reads and returns information from all records (rows) of a database table.
     *
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return              - list of all entities from a database table.
     */
    @Override
    public List<Aircraft> getAll(Connection connection) throws DAOExceptiion {
        return null;
    }

    /**
     * This method reads data from <i>aircrafts</i> database table, creates and returns Aircraft object
     * according to the entered aircraft code, called hull No.
     *
     * @param aicraftCode - an entered aircraft code, called hull No.
     * @param connection  - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return - Aircraft object.
     */
    @Override
    public Aircraft getByCode(String aicraftCode, Connection connection) {
        return null;
    }
}
