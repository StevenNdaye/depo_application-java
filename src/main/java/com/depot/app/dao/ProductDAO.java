package com.depot.app.dao;

import com.depot.app.model.Product;

import java.util.List;

public interface ProductDAO {

    public void addProduct(Product product);
    public List<Product> getAllProducts();
    public void deleteProduct(Integer productId);


    public Product getProduct(Integer id);

    void updateProduct(Product product);
}
