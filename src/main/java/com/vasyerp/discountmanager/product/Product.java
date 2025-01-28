package com.vasyerp.discountmanager.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
// import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Positive(message = "Price must be greater than zero")
    private double price;

    // @PositiveOrZero(message = "Quantity must be greater than or equal to zero")
    @Positive(message = "Quantity must be greater than zero")
    private int quantity;

    private boolean seasonalDiscountActive;

    private double discountedPrice;

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", price=" + price
                + ", quantity=" + quantity
                + ", seasonalDiscountActive=" + seasonalDiscountActive
                + ", discountedPrice=" + getDiscountedPrice()
                + '}';
    }

    public Product(String name, double price, int quantity, boolean seasonalDiscountActive, double discountedPrice) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.seasonalDiscountActive = seasonalDiscountActive;
        this.discountedPrice = discountedPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isSeasonalDiscountActive() {
        return seasonalDiscountActive;
    }

    public void setSeasonalDiscountActive(boolean seasonalDiscountActive) {
        this.seasonalDiscountActive = seasonalDiscountActive;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
