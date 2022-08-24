package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDBConnection {
    public static void main(String[] args) {
        ResultSet resultSet = null;
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
        ) {
            String selectSql = "SELECT TOP 10 Name, Surname from Academy6.dbo.Students";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1)+' '+resultSet.getString(2));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
        ) {
            String selectSql = "SELECT TOP 10 Name, Surname from Academy6.dbo.Students";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1)+' '+resultSet.getString(2));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
