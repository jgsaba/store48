package com.jorge.backend.shoppingapi.service.product;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductClientURIs {

    @Value("${shoppings.product-api.base-url}")
    private String baseClientUri;

    public String getBaseClientUri() {
        return baseClientUri + "/product";
    }
}
