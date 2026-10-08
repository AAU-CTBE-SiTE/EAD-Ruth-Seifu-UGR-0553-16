package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {

        try {
            // MySQL JDBC driver
            String driver = "com.mysql.cj.jdbc.Driver";

            // Database URL
            String url = "jdbc:mysql://localhost:3306/StudentsDB";

            // MySQL credentials
            String username = "ruth";
            String password = "YOUR_PASSWORD";

            // Load the JDBC driver
            Class.forName(driver);

            // Connect to MySQL
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            System.out.println("Established Connection!");

            // Close connection
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}