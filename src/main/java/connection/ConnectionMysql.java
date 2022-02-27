package connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionMysql {

    public Connection getConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(getProperties().getProperty("url1"),
                    getProperties().getProperty("username"),
                    getProperties().getProperty("password"));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return conn;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\NewHomework\\Homework1.1\\src\\main\\java\\Property.properties"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
