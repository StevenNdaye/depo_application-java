package com.depot.app.controller;

import com.depot.app.model.Product;
import com.depot.app.service.ProductManager;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    private ProductController productController;
    private ProductManager productManager;
    String viewName = null;
    List<Product> productList = new ArrayList<Product>();
    Product product = new Product();
    BindingResult bindingResult = new BeanPropertyBindingResult(product, "product");
    ModelMap modelMap = new ModelMap();
    public static final String PRODUCT_KEY = "product";
    public static final int PRODUCT_ID = 100;


    @Before
    public void setUp(){
        productManager = mock(ProductManager.class);
        productController = new ProductController(productManager);
    }

    @Test
    public void itShouldDisplayProductList(){
        when(productManager.getAllProducts()).thenReturn(productList);
        ModelMap modelMap = new ModelMap();
        String viewName = productController.listProducts(modelMap);
        assertThat((List<Product>) modelMap.get("productList"), is(productList));
        assertThat(viewName, is("listProducts"));
    }

    @Test
    public void itShouldAddProduct(){
        productController.addProduct(product, bindingResult);
        verify(productManager).addProduct(product);
    }

    @Test
    public void itShouldDeleteProduct(){
        productController.deleteProduct(PRODUCT_ID);
        verify(productManager).deleteProduct(PRODUCT_ID);
    }

    @Test
    public void itShouldShowViewToCreateNewProduct(){
        viewName = productController.addNewProduct(modelMap);

        assertThat(viewName, is("addProductPage"));
        assertTrue(modelMap.containsKey(PRODUCT_KEY));
        assertThat((Product) modelMap.get(PRODUCT_KEY), is(new Product()));
    }

    @Test
    public void itShouldShowViewToEditProduct(){

        when(productManager.getProduct(PRODUCT_ID)).thenReturn(new Product());
        ModelMap modelMap = new ModelMap();
        viewName = productController.showEditPage(PRODUCT_ID, modelMap);

        assertThat(viewName, is("editProductPage"));
        assertTrue(modelMap.containsKey(PRODUCT_KEY));
        assertThat((Product) modelMap.get(PRODUCT_KEY), is(new Product()));
        verify(productManager).getProduct(PRODUCT_ID);
    }

    @Test
    public void itShouldUpdateProduct(){
        productController.updateProduct(PRODUCT_ID, product, bindingResult);
        verify(productManager).updateProduct(product);
    }

}
