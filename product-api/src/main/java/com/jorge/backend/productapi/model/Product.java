package com.jorge.backend.productapi.model;

import lombok.*;
import model.product.dto.ProductDTO;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productIdentifier;

    private String name;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public static Product convertFrom(ProductDTO productDTO){
        return Product.builder()
                .productIdentifier(productDTO.getProductIdentifier())
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .category(Category.convertFrom(productDTO.getCategoryDTO()))
                .build();
    }
}
