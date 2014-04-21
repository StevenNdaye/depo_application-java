package com.depot.app.controller;

import com.depot.app.model.Product;
import com.depot.app.service.ProductManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    private ProductManager productManager;

    public ProductController(ProductManager productManager){
        this.productManager = productManager;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listProducts(ModelMap modelMap){
        modelMap.addAttribute("productList", productManager.getAllProducts());
        return "listProducts";
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
        return "addProductPage";
    }

    @RequestMapping(value = "edit/{productId}")
    public String showEditPage(@PathVariable("productId") Integer id, ModelMap modelMap){
        modelMap.addAttribute("product", productManager.getProduct(id));
        return "editProductPage";
    }

    @RequestMapping(value = "/edit/{productId}", method = RequestMethod.POST)
    public String updateProduct(@PathVariable("productId") Integer productId,
                                @ModelAttribute(value = "product") Product product, BindingResult result){
        product.setId(productId);
        productManager.updateProduct(product);
        return "redirect:/";
    }
}
