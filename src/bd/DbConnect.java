package bd;

import models.Brand;
import models.Country;
import models.Item;
import models.User;
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
                    "SELECT i.id, i.name, i.description, i.price, b.id as brand_id,  b.brand_name," +
                            "c.id as country_id, c.country_name FROM items i " +
                            "INNER JOIN  brands b on i.brand_id = b.id " +
                            "INNER JOIN  countries c on b.country_id = c.id");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Item it = new Item();
                it.setId(resultSet.getLong("id"));
                it.setName(resultSet.getString("name"));
                it.setDescription(resultSet.getString("description"));
                it.setPrice(resultSet.getDouble("price"));

                Brand brand = new Brand();
                brand.setId(resultSet.getLong("brand_id"));
                brand.setBrand_name(resultSet.getString("brand_name"));

                Country country = new Country();
                country.setId(resultSet.getInt("country_id"));
                country.setCountry_name(resultSet.getString("country_name"));

                brand.setCountry_id(country);
                it.setBrand_id(brand);

                items.add(it);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public static Item getItemById(Long id) {
        Item it = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT i.id, i.name, i.description, i.price, b.id as brand_id,  b.brand_name, c.id as country_id, " +
                            "c.country_name FROM items i " +
                            "INNER JOIN  brands b on i.brand_id = b.id " +
                            "INNER JOIN  countries c on b.country_id = c.id WHERE i.id =?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                it = new Item();
                it.setId(resultSet.getLong("id"));
                it.setName(resultSet.getString("name"));
                it.setDescription(resultSet.getString("description"));
                it.setPrice(resultSet.getDouble("price"));

                Brand brand = new Brand();
                brand.setId(resultSet.getLong("brand_id"));
                brand.setBrand_name(resultSet.getString("brand_name"));

                Country country = new Country();
                country.setId(resultSet.getInt("country_id"));
                country.setCountry_name(resultSet.getString("country_name"));

                brand.setCountry_id(country);
                it.setBrand_id(brand);

                statement.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return it;
    }

    public static List<Brand> getBrands() {
        List<Brand> brands = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM brands");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Brand b = new Brand();
                b.setId(resultSet.getLong("id"));
                b.setBrand_name(resultSet.getString("brand_name"));
                brands.add(b);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brands;
    }

    public static List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM countries");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country c = new Country();
                c.setId(resultSet.getInt("id"));
                c.setCountry_name(resultSet.getString("country_name"));
                countries.add(c);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    public static void addItem(String name, String desc, double price, Long brand_id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO items (name, description, price, brand_id) values (?,?,?,?)");

            statement.setString(1, name);
            statement.setString(2, desc);
            statement.setDouble(3, price);
            statement.setLong(4, brand_id);
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addBrand(String name, Long country_id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO brands (brand_name, country_id) values (?,?)");

            statement.setString(1, name);
            statement.setLong(2, country_id);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateItem(String name, String desc, Double price, Long brand_id, Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE items SET name=?, description=?, price=?, brand_id=? WHERE id=?");

            statement.setString(1, name);
            statement.setString(2, desc);
            statement.setDouble(3, price);
            statement.setLong(4, brand_id);
            statement.setLong(5, id);

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delItemById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE from items WHERE id=?");
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User u = new User();
                u.setId(resultSet.getLong("id"));
                u.setEmail(resultSet.getString("email"));
                u.setFullName(resultSet.getString("fullname"));
                users.add(u);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;

    }

    public static User getUserById(Long id) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE id =?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("fullname"));
                statement.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void deleteUser(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE from users WHERE id=?");
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(String name,String email,Long id){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE users SET fullname=?, email=? WHERE id=?");

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setLong(3, id);
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateUserPass(String pass, Long id){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE users SET password=? WHERE id=?");

            statement.setString(1, pass);
            statement.setLong(2, id);
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
