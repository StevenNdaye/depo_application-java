package com.depot.app.service;

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
public class ProductManagerTest {

    @Autowired
    private ProductManager productManager;

    @Test
    public void itShouldAddAndGetAProduct(){
        productManager.addProduct(createProduct());
        Product product = productManager.getProduct(1);

        assertThat(product.getDescription(), is("Product Description"));
        assertThat(product.getImageUrl(), is("Product Image Url"));
        assertThat(product.getPrice(), is(new BigDecimal(100)));
        assertThat(product.getTitle(), is("Product Title"));
    }


    @Test
    public void itShouldAddTwoProductsAndGetThem(){

        productManager.addProduct(createProduct());
        productManager.addProduct(createProduct());
        List<Product> productList = productManager.getAllProducts();

        for (Product aProductList : productList) {
            assertThat(aProductList.getDescription(), is("Product Description"));
            assertThat(aProductList.getImageUrl(), is("Product Image Url"));
            assertThat(aProductList.getPrice(), is(new BigDecimal(100)));
            assertThat(aProductList.getTitle(), is("Product Title"));
        }
    }

    @Test
    public void itShouldAddAndDeleteAProduct(){
        productManager.addProduct(createProduct());
        assertThat(productManager.getAllProducts().size(), is(1));
        productManager.deleteProduct(1);
        assertThat(productManager.getAllProducts().size(), is(0));
    }

    @Test
    public void itShouldUpdateProduct(){
        productManager.addProduct(createProduct());
        Product product = productManager.getProduct(1);
        assertThat(product.getDescription(), is("Product Description"));
        product.setDescription("Updated Product Description");
        productManager.updateProduct(product);
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
