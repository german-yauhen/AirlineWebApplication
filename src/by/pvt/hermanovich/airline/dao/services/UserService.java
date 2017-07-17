package by.pvt.hermanovich.airline.dao.services;

import by.pvt.hermanovich.airline.constants.MessageConstants;
import by.pvt.hermanovich.airline.dao.implementations.UserDAO;
import by.pvt.hermanovich.airline.entities.User;
import by.pvt.hermanovich.airline.exceptions.DAOException;
import by.pvt.hermanovich.airline.utils.ConnectorDB;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Description: This class describes actions on the user object.
 * This class contains methods that implement work with transaction support.
 *
 * Created by Yauheni Hermanovich on 15.07.2017.
 */
public class UserService {
    private final static Logger logger = Logger.getLogger(UserService.class);
    private volatile static UserService instance;

    public UserService() {
    }

    /**
     * Singleton realization with "Double Checked Locking & Volatile" principle for high performance and thread safety.
     *
     * @return      - an instance of the class.
     */
    public static UserService getInstance() {
        if (instance == null) {
            synchronized (UserService.class) {
                if (instance == null) {
                    return instance = new UserService();
                }
            }
        }
        return instance;
    }

    /**
     * This method checks if the user's login and password are correct. This method implements work with transaction support.
     *
     * @param login         - incoming user's login.
     * @param password      - incoming user's password.
     * @return              - boolean value of the condition if the user is authorized or not.
     * @throws SQLException
     */
    public boolean checkUserAuthorization(String login, String password) throws SQLException {
        boolean isAuthorized = false;
        Connection connection = null;
        try {
            connection = ConnectorDB.getConnection();
            connection.setAutoCommit(false);
            isAuthorized = UserDAO.getInstance().isAuthorized(login, password, connection);
            connection.commit();
            logger.info(MessageConstants.TRANSACTION_SUCCEEDED);
        } catch (SQLException | DAOException e) {
            if (connection != null) {
                connection.rollback();
            }
            logger.error(MessageConstants.TRANSACTION_FAILED, e);
            throw new SQLException(e);
        } finally {
            ConnectorDB.closeConnection(connection);
        }
        return isAuthorized;
    }

    /**
     * This method receives user object. This method implements work with transaction support.
     *
     * @param login     - entered login.
     * @return          - User object.
     */
    public User getUserByLogin(String login) throws SQLException {
        User user = null;
        Connection connection = null;
        try {
            connection = ConnectorDB.getConnection();
            connection.setAutoCommit(false);
            user = UserDAO.getInstance().getByLogin(login, connection);
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
        return user;
    }

    /**
     * This method updates user object. This method implements work with transaction support.
     *
     * @param user          - an user which fields will be updated.
     * @throws SQLException
     */
    public void updateUser(User user) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectorDB.getConnection();
            connection.setAutoCommit(false);
            UserDAO.getInstance().update(user, connection);
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
     * This method checks the uniqueness of the user. This method implements work with transaction support.
     *
     * @param user      - an user object with fields will be checked.
     * @return          - boolean value of the condition.
     * @throws SQLException
     */
    public boolean isUniqueUser(User user) throws SQLException {
        boolean isUnique = false;
        Connection connection = null;
        try {
            connection = ConnectorDB.getConnection();
            connection.setAutoCommit(false);
            if (UserDAO.getInstance().checkUniqueUser(user.getLogin(), connection)) {
                isUnique = true;
            }
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
        return isUnique;
    }

    /**
     * This method registers new user of application. This method implements work with transaction support.
     *
     * @param user      - a new user which will be registered.
     * @throws SQLException
     */
    public void registerUser(User user) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectorDB.getConnection();
            connection.setAutoCommit(false);
            UserDAO.getInstance().add(user, connection);
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
