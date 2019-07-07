package me.bo0tzz.granddigital.model;


public class Product {

  private final int id;
  private final String title;
  private final boolean available;
  private final int year;
  private final Type type;
  private final String url;

  public Product(int id, String title, boolean available, int year, Type type, String url) {
    this.id = id;
    this.title = title;
    this.available = available;
    this.year = year;
    this.type = type;
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public int getYear() {
    return year;
  }
}
