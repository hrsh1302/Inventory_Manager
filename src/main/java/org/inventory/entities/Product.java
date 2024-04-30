package org.inventory.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "Name", length = 50)
    private String name;

    @Column(name = "Description")

    private String description;
    @Column(nullable = false, name = "Category", length = 50)
    private String category;
    @Column(nullable = false, name = "Price")
    private Double price;
    @Column(nullable = false, name = "Quantity")
    private Integer quantity;
    @Column(nullable = false, name = "min_quantity")
    private Integer minQuantity;

    public Product() {
    }

    public Product(Integer id, String name, String description, String category, Double price, Integer quantity, Integer minQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.minQuantity = minQuantity;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getCategory() {
        return category;
    }
    public Double getPrice() {
        return price;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public Integer getMinQuantity() {
        return minQuantity;
    }


    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public void setMinQuantity(Integer minQuantity) {
        this.minQuantity = minQuantity;
    }

    @Override
    public String toString() {
        return "Product Details {\n" +
                "\tID: " + id + "\n" +
                "\tProduct Name: " + name + "\n" +
                "\tCategory: " + category + "\n" +
                "\tPrice: $" + price + "\n" +
                "\tCurrent Stock: " + quantity + "\n" +
                "\tSentinel Stock Value: " + minQuantity + "\n" +
                "\tDescription: " + description + "\n" +
                "}";
    }
}
