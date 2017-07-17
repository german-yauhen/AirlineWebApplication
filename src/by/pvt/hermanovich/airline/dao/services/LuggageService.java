package by.pvt.hermanovich.airline.dao.services;

import by.pvt.hermanovich.airline.constants.MessageConstants;
import by.pvt.hermanovich.airline.dao.implementations.LuggageDAO;
import by.pvt.hermanovich.airline.entities.Luggage;
import by.pvt.hermanovich.airline.exceptions.DAOException;
import by.pvt.hermanovich.airline.utils.ConnectorDB;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Description: This class describes actions on the luggage object.
 * This class contains methods that implement work with transaction support.
 *
 * Created by Yauheni Hermanovich on 17.07.2017.
 */
public class LuggageService {
    private static final Logger logger = Logger.getLogger(LuggageService.class);
    private volatile static LuggageService instance;

    public LuggageService() {
    }

    /**
     * Singleton realization with "Double Checked Locking & Volatile" principle for high performance and thread safety.
     *
     * @return      - an instance of the class.
     */
    public static LuggageService getInstance() {
        if (instance == null) {
            synchronized (LuggageService.class) {
                instance = new LuggageService();
            }
        }
        return instance;
    }

    /**
     * This method checks the uniqueness of the luggage. This method implements work with transaction support.
     *
     * @param luggage   - an luggage object with fields will be checked.
     * @return          - boolean value of the condition.
     */
    public boolean isUniqueLuggage(Luggage luggage) throws SQLException {
        boolean isUnique = false;
        Connection connection = null;
        try {
            connection = ConnectorDB.getConnection();
            connection.setAutoCommit(false);
            if (LuggageDAO.getInstance().checkUniqueLuggage(luggage.getLuggageType(), connection)) {
                isUnique = true;
            }
            connection.commit();
            logger.info(MessageConstants.TRANSACTION_SUCCEEDED);
        } catch (SQLException | DAOException e) {
            if (connection != null) {
                connection.rollback();
            }
            logger.info(MessageConstants.TRANSACTION_SUCCEEDED);
            throw new SQLException(e);
        }
        return isUnique;
    }

    /**
     * This method registers new luggage for users of application. This method implements work with transaction support.
     *
     * @param luggage
     * @throws SQLException
     */
    public void addLuggage(Luggage luggage) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectorDB.getConnection();
            connection.setAutoCommit(false);
            LuggageDAO.getInstance().add(luggage, connection);
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
}
