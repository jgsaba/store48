package com.jorge.backend.shoppingapi.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Item {

    @Column(name = "product_identifier")
    private String productId;

    private BigDecimal price;
}
