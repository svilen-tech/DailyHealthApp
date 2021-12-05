package com.example.dailyhealth.web;

import com.example.dailyhealth.model.PictureEntity;
import com.example.dailyhealth.model.dtos.ProductDto;
import com.example.dailyhealth.model.dtos.CloudinaryImage;
import com.example.dailyhealth.service.CloudinaryService;
import com.example.dailyhealth.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {

    private ProductsService productsService;
    private final CloudinaryService cloudinaryService;

    @GetMapping("products")
    public String listProducts(Model model) {
        List<ProductDto> productDtos = productsService.allProducts();
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
    public String addProductToDB(@Valid ProductDto productDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                 Principal principal) throws IOException {
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("product", productDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.product", bindingResult);
            return "redirect:/products/add";
        }
        final String currentUser = principal.getName();
        var picture = createPictureEntity(productDto.getPicture());
        productsService.addProduct(productDto, currentUser,picture);
        return "redirect:/products";
    }


    @GetMapping("products/myproducts")
    public String showMyProducts(Model model,Principal principal){
        final String currentUser = principal.getName();
        model.addAttribute("myproducts",productsService.myProducts(currentUser));
        return "products/myproducts";
    }

    @Transactional
    @DeleteMapping("/products/myproducts/delete/{id}")
    public String deleteOffer(@PathVariable Long id) {
        productsService.deleteProduct(id);
        return "redirect:/products/myproducts";
    }

    //PICTURES START FROM HERE!
    private PictureEntity createPictureEntity(MultipartFile file) throws IOException {
        final CloudinaryImage uploaded = this.cloudinaryService.upload(file);

        return new PictureEntity().
                setPublicId(uploaded.getPublicId()).
                setUrl(uploaded.getUrl());
    }
}
