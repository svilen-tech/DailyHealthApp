package com.example.dailyhealth.model.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String bestFor;
    private BigDecimal price;
    private String appUser;

    public ProductDto setId(Long id) {
        this.id = id;
        return this;
    }

    public ProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public ProductDto setBestFor(String bestFor) {
        this.bestFor = bestFor;
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
