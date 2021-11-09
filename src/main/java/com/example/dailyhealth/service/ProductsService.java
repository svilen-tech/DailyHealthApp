package com.example.dailyhealth.service;

import com.example.dailyhealth.model.dtos.ProductDto;

import java.util.List;

public interface ProductsService {
    List<ProductDto> allProducts();

    void addProduct(ProductDto productDto, String currentUser);

    List<ProductDto> myProducts(String currentUser);
}
