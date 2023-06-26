package models;

public class Item {
    private Long id;
    private String name;
    private String description;
    private double price;
    private Brand brand_id;

    public Item() {
    }

    public Item(Long id, String name, String description, double price, Brand brand_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.brand_id = brand_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Brand getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Brand brand_id) {
        this.brand_id = brand_id;
    }
}
