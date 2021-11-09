package com.example.dailyhealth.model.entities;

import com.example.dailyhealth.registration.appuser.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String bestFor;
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser appUser;


    public ProductEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public ProductEntity setName(String name) {
        this.name = name;
        return this;
    }

    public ProductEntity setBestFor(String bestFor) {
        this.bestFor = bestFor;
        return this;
    }

    public ProductEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductEntity setAppUser(AppUser appUser) {
        this.appUser = appUser;
        return this;
    }
}
