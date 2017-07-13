package by.pvt.hermanovich.airline.dao;

import by.pvt.hermanovich.airline.entities.BaseEntity;
import by.pvt.hermanovich.airline.exceptions.DAOExceptiion;

import java.sql.Connection;
import java.util.List;

/**
 * Description: This interface describes basic CRUD operations ith database.
 * The parent class for all DAO classes of the project.
 *
 * Created by Yauheni Hermanovich on 10.07.2017.
 */
public interface AbstractDAO<T extends BaseEntity> {

    /**
     * This method creates and inserts an entity in a database table.
     *
     * @param entity            - the current entity which has been created.
     * @param connection        - the current connection to a database. Transmitted from the service module to provide transactions.
     */
    void add(T entity, Connection connection) throws DAOExceptiion;

    /**
     * This method updates an existing record (row) in a database table.
     *
     * @param entity            - the current entity which will be updated.
     * @param connection        - the current connection to a database. Transmitted from the service module to provide transactions.
     */
    void update(T entity, Connection connection) throws DAOExceptiion;

    /**
     * This method reads and returns information from all records (rows) of a database table.
     *
     * @param connection        - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return                  - list of all entities from a database table.
     */
    List<T> getAll(Connection connection) throws DAOExceptiion;
}
