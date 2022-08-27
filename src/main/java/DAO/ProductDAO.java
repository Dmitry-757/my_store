package DAO;

import Model.Directories.Product;

import java.sql.*;

public class ProductDAO {

    public static boolean isExistById(long id) {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            //statement.addBatch(CREATE_TABLE_Products);
            String sql_query = "Select top 1 * from Products where id = " + id;
            ResultSet resultSet = statement.executeQuery(sql_query);
            String name;
            if (resultSet.next()) { //if in result of query exist at list one element
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Product getById(int id) {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql_query = "Select top 1 * from Products where id = " + id;
            ResultSet resultSet = statement.executeQuery(sql_query);
            if (resultSet.next()) {
                int resId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String article = resultSet.getString("article");
                float lastPurchasePrice = resultSet.getInt("lastPurchasePrice");
                float lastSalePrice = resultSet.getInt("lastSalePrice");

                return new Product(resId, article, name, lastPurchasePrice, lastSalePrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static long insert(Product unit) {
        if (!isExistById(unit.getID())) {
            String SQL_Query = "INSERT INTO Products  (article, name, lastPurchasePrice, lastSalePrice) VALUES " +
                    " (?, ?, ?, ?);";
            try (Connection connection = DBConnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SQL_Query,
                         Statement.RETURN_GENERATED_KEYS)
            ) {
                preparedStatement.setString(1, unit.getArticle());
                preparedStatement.setString(2, unit.getName());
                preparedStatement.setString(3, "" + unit.getLastPurchasePrice());
                preparedStatement.setString(4, "" + unit.getLastSalePrice());
//                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
                ResultSet rs = preparedStatement.getGeneratedKeys();
                long idValue;
                if (rs.next()) {
                    idValue = rs.getInt("id");
                    return idValue;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static void update(Product unit) {
        if (isExistById(unit.getID())) {
            String SQL_Query = "update Products set article = ?, name = ?, lastPurchasePrice = ?, lastSalePrice = ? where id = ?;";
            try (Connection connection = DBConnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SQL_Query)
            ) {
                preparedStatement.setString(1, unit.getArticle());
                preparedStatement.setString(2, unit.getName());
                preparedStatement.setString(3, "" + unit.getLastPurchasePrice());
                preparedStatement.setString(4, "" + unit.getLastSalePrice());
                preparedStatement.setString(5, "" + unit.getID());
//            System.out.println(preparedStatement);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
