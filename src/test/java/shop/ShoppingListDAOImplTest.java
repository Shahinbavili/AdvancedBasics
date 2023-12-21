package shop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;
import static org.assertj.core.api.Assertions.fail;

public class ShoppingListDAOImplTest {

    private static final String ERROR = "Connection to DB is not possible";
    private static final String INSERT_SQL = "INSERT INTO item (name, quantity) VALUES (?, ?)";
    private static final String SELECT_SQL = "SELECT * FROM item ORDER BY id DESC LIMIT 1";
    private static final String DELETE_SQL = "DELETE FROM item ORDER BY id DESC LIMIT 1";
    private String host;
    private String user;
    private String password;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        try (InputStream configFile = new FileInputStream("db-config.properties")) {
            Properties properties = new Properties();
            properties.load(configFile);
            host = properties.get("host").toString();
            user = properties.get("user").toString();
            password = properties.get("password").toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void should_connect_to_mySql_database() {
        try (final Connection connection = getConnection(host, user, password)) {
            if (connection == null) {
                fail(ERROR);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Assertions.fail(ERROR);
        }
    }

    @Test
    void should_insert_read_and_delete_an_item_in_database() {
        try (final Connection connection = getConnection(host, user, password);
             final PreparedStatement insert = connection.prepareStatement(INSERT_SQL);
             final PreparedStatement select = connection.prepareStatement(SELECT_SQL);
             final PreparedStatement delete = connection.prepareStatement(DELETE_SQL)) {
            insert.setString(1, "Orange");
            insert.setInt(2, 5);
            insert.executeUpdate();
            ResultSet resultSet = select.executeQuery();
            while (resultSet.next()) {
                final String name = resultSet.getString("name");
                final int quantity = resultSet.getInt("quantity");

                Assertions.assertThat(name).isEqualTo("Orange");
                Assertions.assertThat(quantity).isEqualTo(5);
            }
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            Assertions.fail(ERROR);
        }
    }
}

