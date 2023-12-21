package shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class ShoppingListDAOImpl implements ShoppingListDAO {
    private static final String HOST = "jdbc:mysql://localhost:8889/shop";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String SELECT_SQL = "SELECT * FROM item";
    private static final String INSERT_SQL = "INSERT INTO item (name, quantity) VALUES (?, ?)";

    @Override
    public List<Item> findAllItems() {
        List<Item> items = new LinkedList<>();
        try (final Connection connection = getConnection(HOST, USER, PASSWORD);
             final PreparedStatement select = connection.prepareStatement(SELECT_SQL)) {
            ResultSet resultSet = select.executeQuery();
            while (resultSet.next()) {
                final String name = resultSet.getString("name");
                final int quantity = resultSet.getInt("quantity");
                items.add(new Item(name, quantity));
            }
        } catch (SQLException e) {
            throw new MainSQLException(e);
        }
        return items;
    }

    @Override
    public void saveItems(List<Item> items) {
        try (final Connection connection = getConnection(HOST, USER, PASSWORD);
             final PreparedStatement insert = connection.prepareStatement(INSERT_SQL)) {
            insert.setString(1, "Orange");
            insert.setInt(2, 5);
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new MainSQLException(e);
        }
    }
}


