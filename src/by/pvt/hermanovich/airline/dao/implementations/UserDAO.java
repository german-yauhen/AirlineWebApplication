package by.pvt.hermanovich.airline.dao.implementations;

import by.pvt.hermanovich.airline.dao.ImplUserDAO;
import by.pvt.hermanovich.airline.entities.User;

import java.sql.Connection;
import java.util.List;

/**
 * Description: This class describes methods which work with <i>users</i> database table.
 * Created by Yauheni Hermanovich on 11.07.2017.
 */
public class UserDAO implements ImplUserDAO {

    private volatile static UserDAO instance;

    /**
     * Default constructor.
     */
    public UserDAO() {
    }

    /**
     * Singleton realization with "Double Checked Locking & Volatile" principle for high performance and thread safety.
     *
     * @return - an instance of the class.
     */
    private static UserDAO getInstance() {
        if (instance == null) {
            synchronized (UserDAO.class) {
                if (instance == null) {
                    instance = new UserDAO();
                }
            }
        }
        return instance;
    }

    /**
     * This method creates and inserts an entity in a database table.
     *
     * @param entity     - the current entity which has been created.
     * @param connection - the current connection to a database. Transmitted from the service module to provide transactions.
     */
    @Override
    public void add(User entity, Connection connection) {

    }

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
    @Override
    public boolean isAuthorized(String login, String password, Connection connection) {
        return false;
    }

    /**
     * This method updates an existing record (row) in a database table.
     *
     * @param id         - id number of the current entity which will be updated.
     * @param connection - the current connection to a database. Transmitted from the service module to provide transactions.
     */
    @Override
    public void update(int id, Connection connection) {

    }

    /**
     * This method deletes an existing record (row) in a database table.
     *
     * @param id         - id number of the current entity which will be deleted.
     * @param connection - the current connection to a database. Transmitted from the service module to provide transactions.
     */
    @Override
    public void delete(int id, Connection connection) {

    }

    /**
     * This method reads data from <i>users</i> database table, creates and returns User object according to the entered login.
     *
     * @param login         - entered <i>login</i>.
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return              - User object.
     */
    @Override
    public User getByLogin(String login, Connection connection) {
        return null;
    }

    /**
     * This method reads and returns information from a record (row) of a database table.
     *
     * @param id            - id number of the record (row) in the database table..
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return              - an entity from a database table according to the incoming id number.
     */
    @Override
    public User getById(int id, Connection connection) {
        return null;
    }

    /**
     * This method reads and returns information from all records (rows) of a database table.
     *
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return              - list of all entities from a database table.
     */
    @Override
    public List<User> getAll(Connection connection) {
        return null;
    }
}
