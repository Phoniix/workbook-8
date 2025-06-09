package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection northwindConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind",
                "root", "yearup"
        );
        String country = "USA";
        String query = "SELECT city FROM customers WHERE country = ?";
        PreparedStatement cityQuery = northwindConnection.prepareStatement(query);
        cityQuery.setString(1, country);
        ResultSet cityQueryResults = cityQuery.executeQuery();

        while (cityQueryResults.next()) {
            String city = cityQueryResults.getString("city");
            System.out.println(city);
        }
    }

}
