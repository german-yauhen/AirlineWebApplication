package by.pvt.hermanovich.airline.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Description: This class contains static method which executes reading parameters for connection to database from
 * resource file <i>database.configuration</i> and receive a connection.
 * Created by Yauheni Hermanovich on 10.07.2017.
 */
public class ConnectorDB {
    public static Connection getConnection() throws SQLException {
        ResourceBundle dbProp = ResourceBundle.getBundle("by.pvt.hermanovich.airline.configuration.database");
        return DriverManager.getConnection(
                dbProp.getString("db.url"),
                dbProp.getString("db.user"),
                dbProp.getString("db.password")
        );
    }
}
