package com.first.mvc;

import java.sql.Connection;
import java.sql.Driver;

public class Database {
    private String url = "jdbc:mysql://localhost:3306/mydb";
    private String username = "root";
    private String password = "password";

    public void addUserToDatabase(String name) {
        String insertQuery = "InSERT INTO users (name) VALUES (?)";
        Connection connection = DriverManager.getConnection(url, username, password);

        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }
}ff
