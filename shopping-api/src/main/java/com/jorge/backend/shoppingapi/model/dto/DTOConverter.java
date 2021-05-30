package com.jorge.backend.shoppingapi.model.dto;

import com.jorge.backend.shoppingapi.model.Item;
import com.jorge.backend.shoppingapi.model.Shop;
import model.shopping.dto.ItemDTO;
import model.shopping.dto.ShopDTO;

import java.util.List;
import java.util.stream.Collectors;

public class DTOConverter{

    public static ShopDTO convertFrom(Shop shop){
        return ShopDTO.builder()
                .date(shop.getDate())
                .items(getItems(shop.getItems()))
                .userId(shop.getUserId())
                .total(shop.getTotal())
                .build();
    }

    private static List<ItemDTO> getItems(List<Item> items){
        return items.stream()
                .map(DTOConverter::convertFrom)
                .collect(Collectors.toList());
    }

    public static Shop convertFrom(ShopDTO shopDTO){
        return Shop.builder()
                .userId(shopDTO.getUserId())
                .date(shopDTO.getDate())
                .total(shopDTO.getTotal())
                .items(shopDTO.getItems().stream().map(DTOConverter::convertFrom).collect(Collectors.toList()))
                .build();
    }

    public static Item convertFrom(ItemDTO itemDTO){
        return Item.builder()
                .productId(itemDTO.getProductId())
                .price(itemDTO.getPrice())
                .build();
    }

    public static ItemDTO convertFrom(Item item){
        return ItemDTO.builder()
                .productId(item.getProductId())
                .price(item.getPrice())
                .build();
    }
}
