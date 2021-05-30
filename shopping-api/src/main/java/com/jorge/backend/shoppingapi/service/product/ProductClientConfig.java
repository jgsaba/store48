package com.jorge.backend.shoppingapi.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductClientConfig {

    private final ProductClientURIs productClientURIs;

    public String getProductById(String productIdentifier){
        return new StringBuilder(productClientURIs.getBaseClientUri())
                .append("/")
                .append(productIdentifier)
                .toString();
    }
}
