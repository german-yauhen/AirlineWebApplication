package by.pvt.hermanovich.airline.dao;

import by.pvt.hermanovich.airline.entities.Luggage;
import by.pvt.hermanovich.airline.exceptions.DAOException;

import java.sql.Connection;

/**
 * Description: This interface describes methods for working with <i>luggage</i> database table,
 * extending the capabilities of basic DAO interface.
 *
 * Created by Yauheni Hermanovich on 13.07.2017.
 */
public interface ImplLuggageDAO extends AbstractDAO<Luggage> {

    /**
     * This method reads data from <i>users</i> database table, creates and returns User object according to the entered id.
     *
     * @param id            - entered <i>id</i>.
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return              - Luggage object.
     */
    Luggage getById(int id, Connection connection) throws DAOException;

    /**
     * This method deletes an existing record (row) in a database table.
     *
     * @param id            - entered <i>id</i>.
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     */
    void deleteById(int id, Connection connection) throws DAOException;
}
