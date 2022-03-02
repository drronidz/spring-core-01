package com.springframework.springmvc.controllers;

/*
PROJECT NAME : 6. Introducing Spring MVC
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/26/2022 4:58 PM
*/

import com.springframework.springmvc.domain.Product;
import com.springframework.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/product")
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping({"/list", "/"})
    public String listProducts(Model model) {
        model.addAttribute("products", productService.listAll());
        return "product/productList";
    }

    @RequestMapping("/display/{id}")
    public String displayProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "product/productDisplay";
    }

    @RequestMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/productForm";
    }

    @RequestMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "product/productForm";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.delete(id);
        return "redirect:/product/list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product) {
        Product savedProduct = productService.saveOrUpdate(product);
        System.out.println(savedProduct.getDescription());
        return "redirect:/product/display/" + savedProduct.getId();
    }

}
