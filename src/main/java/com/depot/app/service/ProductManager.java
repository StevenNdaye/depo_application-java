package com.depot.app.service;

import com.depot.app.model.Product;

import java.util.List;

public interface ProductManager {
    public void addProduct(Product product);
    public List<Product> getAllProducts();
    public void deleteProduct(Integer productId);

    public Product getProduct(Integer id);
}
