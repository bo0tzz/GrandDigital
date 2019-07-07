package me.bo0tzz.granddigital.model;


public class Product {

  private final int id;
  private final String name;
  private final boolean available;
  private final int year;
  private final Type type;
  private final String image;

  public Product(int id, String name, boolean available, int year, Type type, String image) {
    this.id = id;
    this.name = name;
    this.available = available;
    this.year = year;
    this.type = type;
    this.image = image;
  }

}
