package com.jorge.backend.productapi.model;

import model.product.dto.CategoryDTO;
import model.product.dto.ProductDTO;

public class DTOConverter {

    public static ProductDTO convertFrom(Product product) {
        return ProductDTO.builder()
                .productIdentifier(product.getProductIdentifier())
                .name(product.getName())
                .price(product.getPrice())
                .categoryDTO(convertFrom(product.getCategory()))
                .build();
    }

    public static CategoryDTO convertFrom(Category category){
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
