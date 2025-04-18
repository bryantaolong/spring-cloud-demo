package com.bryan.model.product;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ClassName: Product
 * Package: com.bryan.product.domain.entity
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 10:31
 * Version: v1.0
 */
@Data
public class Product {
    private Long id;
    private BigDecimal price;
    private String productName;
    private int num;
}
