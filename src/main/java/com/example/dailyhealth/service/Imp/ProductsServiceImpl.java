package com.example.dailyhealth.service.Imp;

import com.example.dailyhealth.model.dtos.ProductDto;
import com.example.dailyhealth.model.entities.ProductEntity;
import com.example.dailyhealth.registration.appuser.AppUserRepository;
import com.example.dailyhealth.repository.ProductRepository;
import com.example.dailyhealth.service.ProductsService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper;
    private AppUserRepository appUserRepository;

    @Override
    public List<ProductDto> allProducts() {
        return productRepository.findAll().stream()
                .map(productEntity -> modelMapper.map(productEntity,ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addProduct(ProductDto productDto, String currentUser) {
        ProductEntity map = modelMapper.map(productDto, ProductEntity.class);
        map.setAppUser(appUserRepository.findByUsername(currentUser).get());
        productRepository.save(map);

    }

    @Override
    public List<ProductDto> myProducts(String currentUser) {
        return productRepository.findAllByAppUserUsername(currentUser).stream()
                .map(productEntity -> modelMapper.map(productEntity,ProductDto.class)).collect(Collectors.toList());
    }
}
