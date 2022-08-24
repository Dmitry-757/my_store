package DAO;

import java.sql.*;

public class MSSQLConnection {
    private static String username = "sa";
    private static String password = "a430LBcn";
    private static String URL = "jdbc:jtds:sqlserver://localhost:1433";
    public static Connection connectionExp;

    static {
//        try (Connection connection = DriverManager.getConnection(URL, username, password);)
        try
        {
            Connection connection = DriverManager.getConnection(URL, username, password);
            if (connection != null) System.out.println("Connection Successful !\n");
            if (connection == null) System.exit(0);

            connectionExp = connection;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        //if connection is closed - lets open it again
        try {
            if (connectionExp.isClosed() ) {
                connectionExp = DriverManager.getConnection(URL, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connectionExp;
    }

    /*
    public static void main(String[] args)
    {

        ResultSet resultSet = null;
        try (Connection connection = getConnection();
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


//        try (Connection connection = DriverManager.getConnection(URL, username, password);
//             Statement statement = connection.createStatement();) {
//
//            if (connection != null) System.out.println("Connection Successful !\n");
//            if (connection == null) System.exit(0);
//
//            // Create and execute a SELECT SQL statement.
//            String selectSql = "SELECT TOP 10 Name, Surname from Academy6.dbo.Students";
//            resultSet = statement.executeQuery(selectSql);
//
//            // Print results from select statement
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(1)+' '+resultSet.getString(2));
//            }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }

    }
    */
}
