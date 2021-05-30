package com.jorge.backend.productapi.repository;

import com.jorge.backend.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory_Id(Long categoryId);

    Optional<Product> findByProductIdentifier(String productIdentifier);
}
