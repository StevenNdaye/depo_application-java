package com.depot.app.controller;

import com.depot.app.model.Product;
import com.depot.app.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    ProductManager productManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listProducts(ModelMap modelMap){
        modelMap.addAttribute("product", new Product());
        modelMap.addAttribute("productList", productManager.getAllProducts());

        return "editProductList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute(value = "product") Product product, BindingResult result){
        productManager.addProduct(product);
        return "redirect:/";
    }

    @RequestMapping("delete/{productId}")
    public String deleteProduct(@PathVariable("productId") Integer productId){
        productManager.deleteProduct(productId);
        return "redirect:/";
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
}
