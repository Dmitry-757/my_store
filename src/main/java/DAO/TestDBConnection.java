package DAO;


public class TestDBConnection {
    public static void main(String[] args) {
        CreateDBTables.prepareBase();
        CreateDBTables.createTables();
    }
}
