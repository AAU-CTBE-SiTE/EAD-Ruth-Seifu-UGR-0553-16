
package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo {

    public static void main(String[] args) {

        // MySQL server credentials
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/";
        String username = "ruth";
        String password = "471440Ruth$";

        try {
            // 1. Load the JDBC driver
            Class.forName(driver);

            System.out.println("JDBC Driver loaded successfully!");

            // 2. Connect to the MySQL server
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            System.out.println("Established Connection!");

            // 3. Create a SQL statement
            Statement statement = connection.createStatement();

            // 4. Create the database
            String createDatabase = "CREATE DATABASE IF NOT EXISTS StudentsDB";
            statement.executeUpdate(createDatabase);

            System.out.println("Database StudentsDB created successfully!");

            // 5. Select the database
            statement.executeUpdate("USE StudentsDB");

            // 6. Create the students table
            String createTable =
                    "CREATE TABLE IF NOT EXISTS students (" +
                            "id INT AUTO_INCREMENT PRIMARY KEY, " +
                            "firstname VARCHAR(50) NOT NULL, " +
                            "lastname VARCHAR(50) NOT NULL, " +
                            "grade DECIMAL(5,2)" +
                            ")";

            statement.executeUpdate(createTable);

            System.out.println("Students table created successfully!");

            // 7. Close resources
            statement.close();
            connection.close();

            System.out.println("Connection closed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
