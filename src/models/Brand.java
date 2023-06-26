package models;

public class Brand {
    private Long id;
    private String brand_name;
    private Country country_id;

    public Brand() {
    }

    public Brand(Long id, String brand_name, Country country_id) {
        this.id = id;
        this.brand_name = brand_name;
        this.country_id = country_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public Country getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Country country_id) {
        this.country_id = country_id;
    }
}
