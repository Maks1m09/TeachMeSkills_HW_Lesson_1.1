package runner;

import util.*;
import connection.*;

import java.sql.*;

public class Runner {
    public static void main(String[] args) {
        ConnectionMysql connectionMysql = new ConnectionMysql();
        try {
            Utilities.newStudent(connectionMysql.getConn());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}