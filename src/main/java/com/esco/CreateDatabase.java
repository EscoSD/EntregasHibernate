package com.esco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CreateDatabase {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String sql = "Create database javieregido";

        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.execute();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
