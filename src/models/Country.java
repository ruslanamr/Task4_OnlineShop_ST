package models;

public class Country {
    private int id;
    private String country_name;

    public Country(int id, String country_name) {
        this.id = id;
        this.country_name = country_name;
    }

    public Country() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}
