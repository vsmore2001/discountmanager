package com.vasyerp.discountmanager.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class DiscountRequest {

    @NotNull(message = "Product ID must not be null")
    private Long productId;

    @NotEmpty(message = "Discount type must not be empty")
    @Pattern(regexp = "^(percentage|flat)$", message = "Discount type must be either 'percentage' or 'flat'")
    private String discountType;

    @Min(value = 0, message = "Discount value must be greater than or equal to 0")
    private double discountValue;

    private boolean seasonalDiscountActive;

    //constructor
    public DiscountRequest() {
    }

    // Getters and setters
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getDiscountType() {
        return discountType;
    }
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }
    public double getDiscountValue() {
        return discountValue;
    }
    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }
    public boolean isSeasonalDiscountActive() {
        return seasonalDiscountActive;
    }
    public void setSeasonalDiscountActive(boolean seasonalDiscountActive) {
        this.seasonalDiscountActive = seasonalDiscountActive;
    }

    //constructor
    public DiscountRequest(Long productId, String discountType, double discountValue, boolean seasonalDiscountActive) {
        this.productId = productId;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.seasonalDiscountActive = seasonalDiscountActive;
    }

    //toString
    @Override
    public String toString() {
        return "DiscountRequest{" +
        "productId=" + productId +
        ", discountType='" + discountType + '\'' +
        ", discountValue=" + discountValue +
        ", seasonalDiscountActive=" + seasonalDiscountActive +
        '}';
    }
}

