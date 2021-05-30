package com.jorge.backend.productapi.service;

import com.jorge.backend.productapi.exception.CategoryNotFoundException;
import com.jorge.backend.productapi.exception.ProductNotFoundException;
import com.jorge.backend.productapi.model.Category;
import com.jorge.backend.productapi.model.DTOConverter;
import com.jorge.backend.productapi.model.Product;
import com.jorge.backend.productapi.repository.CategoryRepository;
import com.jorge.backend.productapi.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import model.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<ProductDTO> getAll(){
        return productRepository.findAll().stream()
                .map(DTOConverter::convertFrom)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByCategoryId(Long categoryId){
        return productRepository.findByCategory_Id(categoryId).stream()
                .map(DTOConverter::convertFrom)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductByIdentifier(String productIdentifier){
        return productRepository.findByProductIdentifier(productIdentifier)
                .map(DTOConverter::convertFrom).orElseThrow(() -> new ProductNotFoundException(productIdentifier));
    }

    public ProductDTO save(ProductDTO productDTO){

        Product newProduct = Product.convertFrom(productDTO);
        Category category = newProduct.getCategory();

        if (!categoryRepository.existsById(category.getId())) {
            throw new CategoryNotFoundException(category.getId());
        }

        return DTOConverter.convertFrom(productRepository.save(newProduct));
    }

    public void delete(Long productId){
        productRepository.findById(productId)
                .ifPresentOrElse(productRepository::delete, ProductNotFoundException::new);
    }
}

