package connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionMysql {
    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String PROPERTY_FILE_PATH = "C:\\NewHomework\\Homework1.1\\src\\main\\java\\Property.properties";
    private Properties properties;
    private java.sql.Connection connection;

    public ConnectionMysql() {
        init();
    }

    public void init() {
        try {
            properties = getProperties();
            Class.forName(MYSQL_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load driver");
            e.printStackTrace();
        }
    }

    public Connection getConn() throws SQLException {
        if (connection != null && connection.isClosed()) {
            return connection;
        }
        try {
            connection = DriverManager.getConnection(getProperties().getProperty("url"),
                    getProperties().getProperty("username"),
                    getProperties().getProperty("password"));
            return connection;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTY_FILE_PATH));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
