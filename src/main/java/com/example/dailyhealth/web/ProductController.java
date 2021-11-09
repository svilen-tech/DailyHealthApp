package com.example.dailyhealth.web;

import com.example.dailyhealth.model.dtos.ProductDto;
import com.example.dailyhealth.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class ProductController {

    private ProductsService productsService;

    @GetMapping("products")
    public String listProducts(Model model) {
        model.addAttribute("products", productsService.allProducts());
        return "products/products";
    }

    @ModelAttribute("product")
    public ProductDto attribute() {
        return new ProductDto();
    }

    @GetMapping("products/add")
    public String addProduct() {
        return "products/addProduct";
    }

    @PostMapping("products/add")
    public String addProductToDB(ProductDto productDto, Principal principal) {
        final String currentUser = principal.getName();
        productsService.addProduct(productDto, currentUser);
        return "redirect:/products";
    }


    @GetMapping("products/myproducts")
    public String showMyProducts(Model model,Principal principal){
        final String currentUser = principal.getName();
        model.addAttribute("myproducts",productsService.myProducts(currentUser));
        return "products/myproducts";
    }
}
