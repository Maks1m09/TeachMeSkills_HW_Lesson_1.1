package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Utilities {
    public static void fullInformation(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        boolean isGetResult = statement.execute("select * from student");
        if (isGetResult) {
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("students_name") + " " +
                        resultSet.getString("cityOfResidence")
                );
            }
        }
    }

    public static void newTown(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new town");
        String town = scanner.nextLine();
        Statement statement = conn.createStatement();
        statement.executeUpdate("insert into student (cityOfResidence) values" +
                "('" + town + "')");
        scanner.close();
    }

    public static void newStudent(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new student");
        String student = scanner.nextLine();
        Statement statement = conn.createStatement();
        statement.executeUpdate("insert into student (students_name) values" +
                "('" + student + "')");
        scanner.close();
    }

    public static void deleteStudentName(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Student name to delete");
        String studentNameToDelete = scanner.nextLine();
        Statement statement = conn.createStatement();
        statement.executeUpdate("DELETE FROM student WHERE students_name like " + "('" + studentNameToDelete + "')");
        scanner.close();
    }

    public static void deleteTown(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Town to delete");
        String townToDelete = scanner.nextLine();
        Statement statement = conn.createStatement();
        statement.executeUpdate("DELETE FROM student WHERE cityOfResidence like " + "('" + townToDelete + "')");
        scanner.close();
    }
}
