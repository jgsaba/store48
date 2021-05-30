package com.jorge.backend.shoppingapi.service.product;

import com.jorge.backend.shoppingapi.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import model.product.dto.ProductDTO;
import model.shopping.dto.ItemDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductClientConfig productClientConfig;

    private final RestTemplate restTemplate;

    public ProductDTO getProductReferencedBy(ItemDTO itemDTO){

        try {
            return restTemplate.getForEntity(productClientConfig.getProductById(itemDTO.getProductId()), ProductDTO.class)
                    .getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new EntityNotFoundException(String.format("Was not found a product with id=%s", itemDTO.getProductId()));
        }
    }
}
