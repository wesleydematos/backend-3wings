package br.com.wesley.teste3wings.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDto {
    @Positive(message = "category_id must be a positive number")
    private long category_id;

    @NotEmpty(message = "name can't be empty")
    @Size(max = 50, message = "name must be lower than 51 characters")
    private String name;

    @NotEmpty(message = "brand can't be empty")
    @Size(max = 50, message = "brand must be lower than 51 characters")
    private String brand;

    @Size(max = 250, message = "description must be lower than 251 characters")
    private String description;

    @Size(max = 250, message = "name must be lower than 251 characters")
    private String whenToTake;

    @NotEmpty(message = "photoUrl can't be empty")
    private String photoUrl;

    @Positive(message = "category_id must be a positive number")
    private Number price;

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category) {
        this.category_id = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWhenToTake() {
        return whenToTake;
    }

    public void setWhenToTake(String whenToTake) {
        this.whenToTake = whenToTake;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }
}
