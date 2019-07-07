package me.bo0tzz.granddigital.service;

import me.bo0tzz.granddigital.model.Product;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class ProductService {

    public void printProductsWithImages(String os, String density) {
        List<Product> products = this.productsWithImages(os, density);
        //Print all products
    }

    private List<Product> productsWithImages(String os, String density) {
        throw new NotImplementedException();
    }

    public void printProductsByYear(String os, String density, int startDate, int endDate) {
        List<Product> products = productsByYear(os, density, startDate, endDate);
        //Print all products
    }

    private List<Product> productsByYear(String os, String density, int startDate, int endDate) {
        throw new NotImplementedException();
    }

}
