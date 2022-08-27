package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDBTables {
    public static void prepareBase() {
        String PREPARE_QUERY =
                "if db_id('myStore') is not null " +
                        "begin " +
                        "alter database myStore set single_user with rollback immediate; " +
                        "drop database myStore; " +
                        "end "+
                        ""+
                        "if db_id('myStore') is  null " +
                        "begin " +
                        "CREATE DATABASE myStore " +
                        "end ";
        try (Connection connection = DBConnection.getConnection("myStore");
             Statement statement = connection.createStatement();
        ) {

            statement.executeUpdate(PREPARE_QUERY);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public static void createTables(){
        String CREATE_TABLE_Products =
                "create table Products "
                        +"("
                        + " id int not null identity(1, 1) primary key, "
                        + " article nvarchar(100) not null unique check (article <> N''), "
                        + " name nvarchar(100) not null, "
                        + " lastPurchasePrice money not null check (lastPurchasePrice >= 0.0), "
                        + " lastSalePrice money not null check (lastSalePrice >= 0.0) "
                        + " );";

        String CREATE_TABLE_Services =
                "create table Services " +
                        "( " +
                        "id int not null identity(1, 1) primary key, " +
                        "name nvarchar(100) not null, " +
                        " );";

        String CREATE_TABLE_Stores =
                "create table Stores " +
                        "( " +
                        "id int not null identity(1, 1) primary key, " +
                        "name nvarchar(100) not null, " +
                        " );";

        String CREATE_TABLE_Purchases =
                "create table Purchases "
                        +"("
                        + " id int not null identity(1, 1) primary key, "
                        + " docNumber nvarchar(12) not null unique check (docNumber <> N''), "
                        + " storeId int not null foreign key (storeId) references Stores(Id)"
                        + " );";

        String CREATE_TABLE_PurchaseProductsString =
                "create table PurchaseProductsString "
                        +"("
                        + " id int not null identity(1, 1) primary key, "
                        + " headId int not null foreign key (headId) references Purchases(Id),"
                        + " productId int not null foreign key (productId) references Products(Id),"
                        + " count decimal(12,2) not null check (count >= 0.0) default 0.0,"
                        + " price money not null check (price >= 0.0) default 0.0"
                        + " );";

        String CREATE_TABLE_PurchaseServicesString =
                "create table PurchaseServicesString "
                        +"("
                        + " id int not null identity(1, 1) primary key, "
                        + " headId int not null foreign key (headId) references Purchases(Id),"
                        + " serviceId int not null foreign key (serviceId) references Services(Id),"
                        + " count int not null check (count >= 0) default 0,"
                        + " price money not null check (price >= 0.0) default 0.0"
                        + " );";


        String CREATE_TABLE_Sales =
                "create table Sales "
                        +"("
                        + " id int not null identity(1, 1) primary key, "
                        + " docNumber nvarchar(12) not null unique check (docNumber <> N''), "
                        + " storeId int not null foreign key (storeId) references Stores(Id)"
                        + " );";

        String CREATE_TABLE_SaleProductsString =
                "create table SaleProductsString "
                        +"("
                        + " id int not null identity(1, 1) primary key, "
                        + " headId int not null foreign key (headId) references Sales(Id),"
                        + " productId int not null foreign key (productId) references Products(Id),"
                        + " count decimal(12,2) not null check (count >= 0.0) default 0.0,"
                        + " price money not null check (price >= 0.0) default 0.0"
                        + " );";

        String CREATE_TABLE_SaleServicesString =
                "create table SaleServicesString "
                        +"("
                        + " id int not null identity(1, 1) primary key, "
                        + " headId int not null foreign key (headId) references Sales(Id),"
                        + " serviceId int not null foreign key (serviceId) references Services(Id),"
                        + " count int not null check (count >= 0) default 0,"
                        + " price money not null check (price >= 0.0) default 0.0"
                        + " );";


        String CREATE_TABLE_Moves =
                "create table Moves "
                        +"("
                        + " id int not null identity(1, 1) primary key, "
                        + " docNumber nvarchar(12) not null unique check (docNumber <> N''), "
                        + " storeDonorId int not null foreign key (storeDonorId) references Stores(Id),"
                        + " storeRecipientId int not null foreign key (storeDonorId) references Stores(Id)"
                        + " );";

        String CREATE_TABLE_MoveProductsString =
                "create table MoveProductsString "
                        +"("
                        + " id int not null identity(1, 1) primary key, "
                        + " headId int not null foreign key (headId) references Moves(Id),"
                        + " productId int not null foreign key (productId) references Products(Id),"
                        + " count decimal(12,2) not null check (count >= 0.0) default 0.0"
                        + " );";


        try (Connection connection = DBConnection.getConnection("myStore");
             Statement statement = connection.createStatement();
        ) {
            statement.addBatch(CREATE_TABLE_Products);
            statement.addBatch(CREATE_TABLE_Services);
            statement.addBatch(CREATE_TABLE_Stores);

            statement.addBatch(CREATE_TABLE_Purchases);
            statement.addBatch(CREATE_TABLE_PurchaseProductsString);
            statement.addBatch(CREATE_TABLE_PurchaseServicesString);


            statement.addBatch(CREATE_TABLE_Sales);
            statement.addBatch(CREATE_TABLE_SaleProductsString);
            statement.addBatch(CREATE_TABLE_SaleServicesString);


            statement.addBatch(CREATE_TABLE_Moves);
            statement.addBatch(CREATE_TABLE_MoveProductsString);

            statement.executeBatch();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
