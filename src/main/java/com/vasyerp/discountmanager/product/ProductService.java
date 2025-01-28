package com.vasyerp.discountmanager.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.vasyerp.discountmanager.exception.InvalidDiscountTypeException;
import com.vasyerp.discountmanager.exception.OutOfStockException;
import com.vasyerp.discountmanager.exception.ProductNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product applyDiscount(Long productId, String discountType, double discountValue, boolean seasonalDiscountActive) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        if (product.getQuantity() <= 0) {
            throw new OutOfStockException("Product is out of stock");
        }

        double discount = 0;
        if ("percentage".equalsIgnoreCase(discountType)) {
            discount = product.getPrice() * (discountValue / 100);
        } else if ("flat".equalsIgnoreCase(discountType)) {
            discount = discountValue;
        } else {
            throw new InvalidDiscountTypeException("Invalid discount type");
        }

        if (seasonalDiscountActive) {
            discount += product.getPrice() * 0.25; // 25% seasonal discount
        }

        double finalPrice = product.getPrice() - discount;
        product.setDiscountedPrice(Math.max(finalPrice, 0)); // Ensure price doesn't go negative

        return productRepository.save(product);
    }

    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    public List<Product> getAllProducts() {
        // Fetch all products from the database
        return productRepository.findAll();
    }
    
    public Product addProduct(@RequestBody Product product) {
        // Ensure the discounted price is initially set to 0
        product.setDiscountedPrice(0);
        return productRepository.save(product);
    }
}
