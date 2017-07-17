package by.pvt.hermanovich.airline.dao;

import by.pvt.hermanovich.airline.entities.User;
import by.pvt.hermanovich.airline.exceptions.DAOException;
import java.sql.Connection;

/**
 * Description: This interface describes methods for working with <i>users</i> database table,
 * extending the capabilities of basic DAO interface.
 *
 * Created by Yauheni Hermanovich on 10.07.2017.
 */
public interface ImplUserDAO extends AbstractDAO<User> {

    /**
     * This method checks the availability of the <i>login</i> and <i>password</i> in the <i>users</i> database table.
     *
     * @param login         - entered <i>login</i> filed of the user.
     * @param password      - entered <i>password</i> field of the user.
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return              - boolean value of the condition:
     *                          returns "true" if the incoming data correspond to the record of the database table;
     *                          returns "false" if the incoming data do not correspond to the record of the database table.
     */
    boolean isAuthorized(String login, String password, Connection connection) throws DAOException;

    /**
     * This method reads data from <i>users</i> database table, creates and returns User object according to the entered login.
     *
     * @param login         - entered <i>login</i>.
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return              - User object.
     */
    User getByLogin(String login, Connection connection) throws DAOException;

    /**
     * This method deletes an existing record (row) in a database table.
     *
     * @param id            - id number of the current entity which will be deleted.
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     */
    void deleteById(int id, Connection connection) throws DAOException;

    /**
     * This method check the uniqueness of the user.
     *
     * @param login         - entered <i>login</i>.
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return              - boolean value of the condition:
     *                          returns "false" if the incoming data correspond to the record of the database table;
     *                          returns "true" if the incoming data do not correspond to the record of the database table.
     * @throws DAOException
     */
    boolean checkUniqueUser(String login, Connection connection) throws DAOException;


    /**
     * This method reads and returns information from a record (row) of a database table.
     *
     * @param id            - id number of the record (row) in the database table..
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return              - an entity from a database table according to the incoming id number.
     */
    User getById(int id, Connection connection) throws DAOException;
}
