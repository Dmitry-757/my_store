package DAO;

import java.sql.Connection;

public class DBConnection {
    public static Connection getConnection(String dbName){
        return MSSQLConnection.getConnection(dbName);
    }
}
