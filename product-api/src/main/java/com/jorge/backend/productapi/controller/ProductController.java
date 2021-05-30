package com.jorge.backend.productapi.controller;

import com.jorge.backend.productapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import model.product.dto.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public List<ProductDTO> getAllProducts(){
        return productService.getAll();
    }

    @GetMapping("/{productIdentifier}")
    public ProductDTO findById(@PathVariable String productIdentifier){
        return productService.getProductByIdentifier(productIdentifier);
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductByCategory(@PathVariable Long categoryId){
        return productService.getProductByCategoryId(categoryId);
    }
}
