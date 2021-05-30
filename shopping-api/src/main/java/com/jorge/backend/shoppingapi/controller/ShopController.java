package com.jorge.backend.shoppingapi.controller;

import com.jorge.backend.shoppingapi.service.ShopService;
import model.shopping.dto.ShopDTO;
import model.shopping.dto.ShopReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RequestMapping("/shopping")
@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/all-shoppings")
    public List<ShopDTO> getAllShoppings(){
        return shopService.getAll();
    }

    @GetMapping("/user/{userId}")
    public List<ShopDTO> getShoppingsByUserId(@PathVariable String userId){
        return shopService.getShoppingsByUser(userId);
    }

    @GetMapping("/by-date")
    public List<ShopDTO> getShoppingsByDate(@RequestBody ShopDTO shopDTO){
        return shopService.findByDate(shopDTO);
    }

    @GetMapping("/{id}")
    public ShopDTO findById(@PathVariable Long id) {
        return shopService.findById(id);
    }

    @GetMapping("/search")
    public List<ShopDTO> search(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate startDate,
                                @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate endDate,
                                @RequestParam(required = false) BigDecimal minValue){

        return shopService.getShopByFilters(startDate, endDate, minValue);
    }

    @GetMapping("/report")
    public ShopReportDTO getReportByDate(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate startDate,
                                         @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate endDate){

        return shopService.getReportByDate(startDate, endDate);
    }

    @PostMapping("/shopping")
    public ShopDTO newShop(@Valid @RequestBody ShopDTO shopDTO, @RequestHeader String key) {
        return shopService.save(shopDTO, key);
    }

}
