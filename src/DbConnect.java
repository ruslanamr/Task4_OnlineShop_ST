import models.Item;
import models.User;
import org.postgresql.Driver;

import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbConnect {

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Task4_OnlineShop_SPRINT TASK",
                    "postgres",
                    "postgres"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM items ORDER BY id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Item it = new Item();
                it.setId(resultSet.getLong("id"));
                it.setName(resultSet.getString("name"));
                it.setDescription(resultSet.getString("description "));
                it.setPrice(resultSet.getDouble("price"));
                items.add(it);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public static User autoBd(String email, String pass) {
        User u = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE email=?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                u = new User();
                u.setFullName(resultSet.getString("fullName"));
                u.setEmail(resultSet.getString("email"));
                u.setPassword(resultSet.getString("password"));
                u.setId(resultSet.getLong("id"));
                statement.close();

                if (u.getPassword().equals(pass)) {
                    return u;
                }
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addUser(User u) {

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users (email, password, fullname) values (?,?,?)"
            );
            statement.setString(1, u.getEmail());
            statement.setString(2, u.getPassword());
            statement.setString(3, u.getFullName());
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
