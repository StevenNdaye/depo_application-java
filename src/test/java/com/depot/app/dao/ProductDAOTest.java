package com.depot.app.dao;

import com.depot.app.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/test-application-context.xml")
@Transactional
@TransactionConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductDAOTest{

    @Autowired
    private ProductDAO productDAO;

    @Test
    public void itShouldAddAndGetAProduct(){

        productDAO.addProduct(createProduct());
        Product product = productDAO.getProduct(1);

        assertThat(product.getDescription(), is("Product Description"));
        assertThat(product.getImageUrl(), is("Product Image Url"));
        assertThat(product.getPrice(), is(new BigDecimal(100)));
        assertThat(product.getTitle(), is("Product Title"));
    }

    @Test
    public void itShouldAddTwoProductsAndGetThem(){

        productDAO.addProduct(createProduct());
        productDAO.addProduct(createProduct());
        List<Product> productList = productDAO.getAllProducts();

        for (Product aProductList : productList) {
            assertThat(aProductList.getDescription(), is("Product Description"));
            assertThat(aProductList.getImageUrl(), is("Product Image Url"));
            assertThat(aProductList.getPrice(), is(new BigDecimal(100)));
            assertThat(aProductList.getTitle(), is("Product Title"));
        }
    }

    @Test
    public void itShouldAddAndDeleteAProduct(){
        productDAO.addProduct(createProduct());
        assertThat(productDAO.getAllProducts().size(), is(1));
        productDAO.deleteProduct(1);
        assertThat(productDAO.getAllProducts().size(), is(0));
    }

    @Test
    public void itShouldUpdateProduct(){
        productDAO.addProduct(createProduct());
        Product product = productDAO.getProduct(1);
        assertThat(product.getDescription(), is("Product Description"));
        product.setDescription("Updated Product Description");
        productDAO.updateProduct(product);
        assertThat(product.getDescription(), is("Updated Product Description"));
    }

    private Product createProduct() {
        Product product = new Product();
        product.setDescription("Product Description");
        product.setImageUrl("Product Image Url");
        product.setPrice(new BigDecimal(100));
        product.setTitle("Product Title");
        return product;
    }

}
