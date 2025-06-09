package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection northwindConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind",
                "root", "yearup"
        );
        String query = "SELECT p.ProductID, p.ProductName, p.UnitPrice, p.UnitsInStock " +
                "FROM Products p";
        PreparedStatement productQuery = northwindConnection.prepareStatement(query);
        ResultSet cityQueryResults = productQuery.executeQuery();

        while (cityQueryResults.next()) {
            int productId = cityQueryResults.getInt("ProductID");
            String productName = cityQueryResults.getString("ProductName");
            double unitPrice = cityQueryResults.getDouble("UnitPrice");
            int unitsInStock = cityQueryResults.getInt("UnitsInStock");

            System.out.println("Product ID: " + productId +
                    "\nProduct Name: " + productName +
                    "\nUnit Price: " + unitPrice +
                    "\nUnits In Stock: " + unitsInStock +
                    "\n------------------------------------------------"
            );
        }
    }

}
