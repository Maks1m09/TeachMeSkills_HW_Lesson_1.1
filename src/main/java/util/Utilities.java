package util;

import model.Student;
import model.Town;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Utilities  {

    public static void fullInformation(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        boolean isGetResult = statement.execute("SELECT name, last_name, name_town FROM student LEFT JOIN town ON student.id = town.id");
        if (isGetResult) {
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " +
                        resultSet.getString("last_name") +
                        " " + resultSet.getString("name_town")
                );
            }
        }
        conn.close();
    }

    public static void newTown(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new town");
        String townName = scanner.nextLine();
        System.out.println("Enter new idForTown");
        int idTown = scanner.nextInt();
        Town town = new Town();
        town.setNameTown(townName);
        town.setId(idTown);
        Statement statement = conn.createStatement();
        try {
            statement.executeUpdate("insert into town (name_town, id) values" +
                    "('" + town.getNameTown() + "'" + "," + town.getId() + ")");
        } catch (SQLException e) {
            System.out.println("This id number is already reserved for another town");
        } finally {
            System.out.println("Execute operation");
        }
        scanner.close();
        conn.close();
    }

    public static void newStudent(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new student");
        System.out.println("Enter new student name");
        String studentName = scanner.nextLine();
        System.out.println("Enter new student last name");
        String studentLastName = scanner.nextLine();
        System.out.println("Enter new student id");
        int studentId = scanner.nextInt();
        Student student = new Student();
        student.setName(studentName);
        student.setLastName(studentLastName);
        student.setId(studentId);
        Statement statement = conn.createStatement();
        try {
            statement.executeUpdate("insert into student (name, last_name, id) values" +
                    "('" + student.getName() + "'" + "," + "'" + student.getLastName() + "'" + "," + +student.getId() + ")");
        } catch (SQLException e) {
            System.out.println("This id number is already reserved for another student");
        } finally {
            System.out.println("Execute operation");
        }
        scanner.close();
        conn.close();
    }

    public static void deleteStudentName(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Student name to delete");
        String studentNameToDelete = scanner.nextLine();
        Statement statement = conn.createStatement();
        try {
            statement.executeUpdate("DELETE FROM student WHERE name like " + "('" + studentNameToDelete + "')");
        } catch (SQLException e) {
            System.out.println("name not found");
        } finally {
            System.out.println("Execute operation");
        }
        scanner.close();
        conn.close();
    }

    public static void deleteStudentNameById(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number id to delete");
        int numberIdToDelete = scanner.nextInt();
        Statement statement = conn.createStatement();
        try {
            statement.executeUpdate("DELETE FROM student WHERE id like " + "('" + numberIdToDelete + "')");
        } catch (SQLException e) {
            System.out.println("no name found with this id");
        } finally {
            System.out.println("Execute operation");
        }
        scanner.close();
        conn.close();
    }

    public static void deleteTown(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Town to delete");
        String townToDelete = scanner.nextLine();
        Statement statement = conn.createStatement();
        try {
            statement.executeUpdate("DELETE FROM student WHERE cityOfResidence like " + "('" + townToDelete + "')");
        } catch (SQLException e) {
            System.out.println("town not found");
        } finally {
            System.out.println("Execute operation");
        }
        scanner.close();
        conn.close();
    }

    public static void deleteTownById(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Town to delete by id");
        int townToDeleteById = scanner.nextInt();
        Statement statement = conn.createStatement();
        try {
            statement.executeUpdate("DELETE FROM student WHERE cityOfResidence like " + "('" + townToDeleteById + "')");
        } catch (SQLException e) {
            System.out.println("no town found with this id");
        } finally {
            System.out.println("Execute operation");
        }
        scanner.close();
        conn.close();
    }
}
