package com.bryan.model.order;

import com.bryan.model.product.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: Order
 * Package: com.bryan.order.domain.entity
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 10:45
 * Version: v1.0
 */
@Data
public class Order {
    private Long id;
    private BigDecimal totalAmount;
    private Long userId;
    private String nickName;
    private String address;
    private List<Product> productList;
}
