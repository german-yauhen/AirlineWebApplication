package by.pvt.hermanovich.airline.dao;

import by.pvt.hermanovich.airline.entities.User;

import java.sql.Connection;

/**
 * Description: This interface describes methods for working with <i>users</i> database table.
 * Created by Yauheni Hermanovich on 10.07.2017.
 */
public interface ImplUserDAO extends AbstractDAO<User> {

    /**
     * This method checks the availability of the <i>login</i> and <i>password</i> in the <i>users</i> database table.
     *
     * @param login         - entered <i>login</i> filed of the user.
     * @param password      - entered <i>password</i> field of the user.
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return              - boolean value of the operation:
     *                          returns "true" if the incoming data correspond to the record of the database table;
     *                          returns "false" if the incoming data do not correspond to the record of the database table.
     */
    boolean isAuthorized(String login, String password, Connection connection);

    /**
     * This method reads data from <i>users</i> database table, creates and returns User object according to the entered login.
     *
     * @param login         - entered <i>login</i>.
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return              - User object.
     */
    User getByLogin(String login, Connection connection);
}
