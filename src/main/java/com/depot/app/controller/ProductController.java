package com.depot.app.controller;

import com.depot.app.model.Product;
import com.depot.app.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    ProductManager productManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listProducts(ModelMap modelMap){
        modelMap.addAttribute("productList", productManager.getAllProducts());

        return "products";
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

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addNewProduct(ModelMap modelMap){
        modelMap.addAttribute("product", new Product());
        return "addProduct";
    }

    @RequestMapping(value = "edit/{productId}")
    public String showEditPage(@PathVariable("productId") Integer id, ModelMap modelMap){
        modelMap.addAttribute("product", productManager.getProduct(id));
        return "editProduct";
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
}
