package com.depot.app.controller;

import com.depot.app.model.Product;
import com.depot.app.service.ProductManager;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductControllerTest {

    private ProductController productController;
    private ProductManager productManager;

    @Before
    public void setUp(){
        productManager = mock(ProductManager.class);
        productController = new ProductController(productManager);
    }
    @Test
    public void shouldDisplayProductList(){
        List<Product> productList = new ArrayList<Product>();
        when(productManager.getAllProducts()).thenReturn(productList);
        ModelMap modelMap = new ModelMap();
        String viewName = productController.listProducts(modelMap);
        assertThat((List<Product>) modelMap.get("productList"), is(productList));
        assertThat(viewName, is("listProducts"));
    }
}
