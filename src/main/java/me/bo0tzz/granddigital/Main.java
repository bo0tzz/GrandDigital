package me.bo0tzz.granddigital;

import me.bo0tzz.granddigital.service.ProductService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        ProductService productService = new ProductService();
        switch (args.length) {
            case 2:
                productService.printProductsWithImages(args[0], args[1]);
                break;
            case 4:
                int startYear = Integer.parseInt(args[2]);
                int endYear = Integer.parseInt(args[3]);
                productService.printProductsByYear(args[0], args[1], startYear, endYear);
                break;
            default:
                System.out.println("Invalid arguments supplied");
        }
    }

}
