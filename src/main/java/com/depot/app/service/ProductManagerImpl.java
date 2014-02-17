package com.depot.app.service;

import com.depot.app.dao.ProductDAO;
import com.depot.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductManagerImpl implements ProductManager{

    @Autowired
    private ProductDAO productDAO;

    @Override
    @Transactional
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    @Transactional
    public void deleteProduct(Integer productId) {
        productDAO.deleteProduct(productId);
    }

    @Override
    @Transactional
    public Product getProduct(Integer id){
        return productDAO.getProduct(id);
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
}
