package me.bo0tzz.granddigital.db;

import me.bo0tzz.granddigital.model.OS;
import me.bo0tzz.granddigital.model.Product;
import me.bo0tzz.granddigital.model.Size;
import me.bo0tzz.granddigital.model.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private final PreparedStatement simpleRetrieve;
    private final PreparedStatement dateRangeRetrieve;

    public Database() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gd?user=root&password=pass1234");
        simpleRetrieve = connection.prepareStatement("SELECT * FROM products WHERE available=TRUE");
        dateRangeRetrieve = connection.prepareStatement("SELECT * FROM products WHERE available=TRUE AND year >= ? AND year <= ?");
    }

    public List<Product> retrieveAllAvailable(OS os, Size size) throws SQLException {
        //We pass in OS and Size to determine image URL here. Is there a cleaner way?
        ResultSet result = simpleRetrieve.executeQuery();
        return productsFrom(result, os, size);
    }

    public List<Product> retrieveAllInRange(OS os, Size size, int start, int end) throws SQLException {
        dateRangeRetrieve.setInt(1, start);
        dateRangeRetrieve.setInt(2, end);

        ResultSet result = dateRangeRetrieve.executeQuery();
        return productsFrom(result, os, size);
    }

    private List<Product> productsFrom(ResultSet result, OS os, Size size) throws SQLException {
        List<Product> products = new ArrayList<>();

        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("title");
            int year = result.getInt("year");
            String type = result.getString("type");
            String image = result.getString("url");

            Product product = new Product(
                    id,
                    name,
                    true,
                    year,
                    Type.valueOf(type),
                    size.urlFor(os, image)
            );

            products.add(product);
        }

        return products;
    }

}
