package by.pvt.hermanovich.airline.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Description: This class contains static method which executes reading parameters for connection to database from
 * resource file <i>database.configuration</i> and receive a connection.
 * Created by Yauheni Hermanovich on 10.07.2017.
 */
public class ConnectorDB {

    /**
     * This method provides making a connection to database using a property file.
     *
     * @return - connection to database.
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                ConfigManagerDB.getInstance().getProperty("db.url"),
                ConfigManagerDB.getInstance().getProperty("db.user"),
                ConfigManagerDB.getInstance().getProperty("db.password")
        );
    }

    /**
     * This method closes Statement after the queries have been executed.
     *
     * @param statement - an using statement.
     */
    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Statement is null.\n" + e);
            }
        }
    }

    /**
     * This method closes ResultSet after queries have been executed and information have been processed.
     *
     * @param resultSet - the result from the query.
     */
    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("ResultSet is null.\n" + e);
            }
        }
    }

    /**
     * This method closes Connection after queries have been executed and information have been processed.
     *
     * @param connection - an using connection.
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Connection is null.\n" + e);
            }
        }
    }
}
