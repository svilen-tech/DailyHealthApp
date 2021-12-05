package com.example.dailyhealth.model.dtos;

import com.example.dailyhealth.model.PictureViewModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class ProductDto {
    private Long id;
    @Size(min = 3,max=20,message = "Size must be between 3 and 20")
    private String name;
    @Size(min = 3,max=20,message = "Size must be between 3 and 20")
    private String brand;
    @NotNull
    @Positive(message = "Must be greater than 0")
    private BigDecimal price;
    private String appUser;
    private MultipartFile picture;
    private PictureViewModel pictureViewModel;

    public ProductDto setPictureViewModel(PictureViewModel pictureViewModel) {
        this.pictureViewModel = pictureViewModel;
        return this;
    }

    public ProductDto setPicture(MultipartFile picture) {
        this.picture = picture;
        return this;
    }

    public ProductDto setId(Long id) {
        this.id = id;
        return this;
    }

    public ProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public ProductDto setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public ProductDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductDto setAppUser(String appUser) {
        this.appUser = appUser;
        return this;
    }
}
