package com.depot.app.dao;

import com.depot.app.model.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProduct(Product product) {
        this.sessionFactory.getCurrentSession().save(product);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getAllProducts() {
        return this.sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    @Override
    public void deleteProduct(Integer productId) {
        Product product = (Product)this.sessionFactory.getCurrentSession().load(Product.class,productId);
        if(null != product){
            this.sessionFactory.getCurrentSession().delete(product);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Product getProduct(Integer id){
        return (Product) this.sessionFactory.getCurrentSession().createQuery("from Product where id =" + id).list().get(0);
    }

    @Override
    public void updateProduct(Product product) {
        this.sessionFactory.getCurrentSession().update(product);
    }

}
