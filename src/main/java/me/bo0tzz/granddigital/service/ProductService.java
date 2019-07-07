package me.bo0tzz.granddigital.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.bo0tzz.granddigital.db.Database;
import me.bo0tzz.granddigital.gson.BaseExclusionStrategy;
import me.bo0tzz.granddigital.gson.WithYearExclusionStrategy;
import me.bo0tzz.granddigital.model.OS;
import me.bo0tzz.granddigital.model.Output;
import me.bo0tzz.granddigital.model.Product;
import me.bo0tzz.granddigital.model.Size;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class ProductService {

    private final Database database;

    public ProductService() throws SQLException {
        this.database = new Database();
    }

    public void printProductsWithImages(String os, String size) throws SQLException {
        Output products = this.productsWithImages(OS.valueOf(os.toUpperCase()), Size.valueOf(size.toUpperCase()));

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .addSerializationExclusionStrategy(new BaseExclusionStrategy())
                .create();

        String json = gson.toJson(products);
        System.out.println(json);
    }

    private Output productsWithImages(OS os, Size size) throws SQLException {
        List<Product> products = database.retrieveAllAvailable(os, size);
        products.sort(Comparator.comparing(Product::getTitle));
        return new Output(products);
    }

    public void printProductsByYear(String os, String size, int startDate, int endDate) throws SQLException {
        Output products = productsByYear(OS.valueOf(os.toUpperCase()), Size.valueOf(size.toUpperCase()), startDate, endDate);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .addSerializationExclusionStrategy(new WithYearExclusionStrategy())
                .create();

        String json = gson.toJson(products);
        System.out.println(json);
    }

    private Output productsByYear(OS os, Size size, int startDate, int endDate) throws SQLException {
        List<Product> products = database.retrieveAllInRange(os, size, startDate, endDate);
        products.sort(Comparator.comparing(Product::getYear));
        return new Output(products);
    }

}
