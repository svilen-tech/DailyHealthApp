package com.example.dailyhealth.service.Imp;

import com.example.dailyhealth.model.PictureEntity;
import com.example.dailyhealth.model.PictureViewModel;
import com.example.dailyhealth.model.dtos.ProductDto;
import com.example.dailyhealth.model.entities.ProductEntity;
import com.example.dailyhealth.registration.appuser.AppUserRepository;
import com.example.dailyhealth.repository.PictureRepository;
import com.example.dailyhealth.repository.ProductRepository;
import com.example.dailyhealth.service.CloudinaryService;
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
    private final CloudinaryService cloudinaryService;
    private final PictureRepository pictureRepository;

    @Override
    public List<ProductDto> allProducts() {
        List<ProductDto> collect = productRepository.findAll().stream()
                .map(productEntity -> {
                    ProductDto map = modelMapper.map(productEntity, ProductDto.class);

                    map.setPictureViewModel(new PictureViewModel().setPublicId(productEntity.getPicture().getPublicId()).
                            setUrl(productEntity.getPicture().getUrl()));
                    return map;
                }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void addProduct(ProductDto productDto, String currentUser, PictureEntity picture) {
        ProductEntity map = modelMapper.map(productDto, ProductEntity.class);
        map.setAppUser(appUserRepository.findByUsername(currentUser).get());
        pictureRepository.save(picture);
        map.setPicture(picture);
        productRepository.save(map);

    }

    @Override
    public List<ProductDto> myProducts(String currentUser) {
        List<ProductDto> collect = productRepository.findAllByAppUserUsername(currentUser).stream()
                .map(productEntity -> {
                    ProductDto map = modelMapper.map(productEntity, ProductDto.class);

                    map.setPictureViewModel(new PictureViewModel().setPublicId(productEntity.getPicture().getPublicId()).
                            setUrl(productEntity.getPicture().getUrl()));
                    return map;
                }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void deleteProduct(Long id) {
        ProductEntity byId = productRepository.findById(id).get();
        if (cloudinaryService.delete(byId.getPicture().getPublicId())) {
            pictureRepository.deleteAllByPublicId(byId.getPicture().getPublicId());
        }
        productRepository.deleteById(id);
    }
}
