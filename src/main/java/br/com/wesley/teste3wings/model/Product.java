package br.com.wesley.teste3wings.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(nullable = false, referencedColumnName = "id")
    private Category category;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String brand;

    @Column(length = 250)
    private String description;

    @Column(length = 250)
    private String whenToTake;

    @Column(nullable = false)
    private String photoUrl;

    @Column(nullable = false)
    private Number price;

    public Product() {
    }

    public Product(Category category, String name, String brand, String description, String whenToTake, String photoUrl, Number price) {
        this.category = category;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.whenToTake = whenToTake;
        this.photoUrl = photoUrl;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) { this.category = category; }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getWhenToTake() {
        return whenToTake;
    }

    public void setWhenToTake(String whenToTake) {
        this.whenToTake = whenToTake;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", whenToTake='" + whenToTake + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", price=" + price +
                '}';
    }
}
