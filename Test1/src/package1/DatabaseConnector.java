package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DatabaseConnector class establishes a connection to the database.
 */
public class DatabaseConnector {

    /**
     * Establishes a connection to the database using the provided properties.
     *
     * @param properties database configuration properties
     * @return Connection object representing the database connection
     * @throws SQLException if a database access error occurs
     */
    public static Connection connectToDatabase(Properties properties) throws SQLException {
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }
}
