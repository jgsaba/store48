package com.jorge.backend.shoppingapi.service;

import com.jorge.backend.shoppingapi.model.dto.DTOConverter;
import com.jorge.backend.shoppingapi.repository.ShopRepository;
import com.jorge.backend.shoppingapi.service.product.ProductService;
import com.jorge.backend.shoppingapi.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import model.exceptions.ShopNotFoundException;
import model.product.dto.ProductDTO;
import model.shopping.dto.ShopDTO;
import model.shopping.dto.ShopReportDTO;
import model.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    public List<ShopDTO> getAll(){
        return shopRepository.findAll().stream()
                .map(DTOConverter::convertFrom)
                .collect(Collectors.toList());
    }

    public ShopReportDTO getReportByDate(LocalDate startDate, LocalDate endDate){
        return shopRepository.getReportByDate(startDate, endDate);
    }

    public List<ShopDTO> getShopByFilters(LocalDate startDate, LocalDate endDate, BigDecimal minValue){
        return shopRepository.getShopByFilters(startDate, endDate, minValue).stream()
                .map(DTOConverter::convertFrom)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getShoppingsByUser(String userId){
        return shopRepository.findAllByUserId(userId).stream()
                .map(DTOConverter::convertFrom)
                .collect(Collectors.toList());
    }

    public ShopDTO findById(Long shopId){
        return shopRepository.findById(shopId)
                .map(DTOConverter::convertFrom)
                .orElseThrow(() -> new ShopNotFoundException(shopId));
    }

    public List<ShopDTO> findByDate(ShopDTO shopDTO){
        return shopRepository.findAllByDateGreaterThan(shopDTO.getDate()).stream()
                .map(DTOConverter::convertFrom)
                .collect(Collectors.toList());
    }

    public ShopDTO save(ShopDTO shopDTO, String key) {
        UserDTO user = userService.getUserByCpf(shopDTO.getUserId(), key);
        log.info("Processing shoppings for client: {}, CPF: {}", user.getName(), user.getCpf());

        BigDecimal total = shopDTO.getItems().stream()
                .map(productService::getProductReferencedBy)
                .map(ProductDTO::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        shopDTO.setTotal(total);
        shopDTO.setDate(LocalDate.now().plusDays(5));

        return DTOConverter.convertFrom(shopRepository.save(DTOConverter.convertFrom(shopDTO)));
    }
}
