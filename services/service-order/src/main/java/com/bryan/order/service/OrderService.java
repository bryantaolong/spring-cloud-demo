package com.bryan.order.service;

import com.bryan.model.order.Order;

/**
 * ClassName: OrderService
 * Package: com.bryan.order.service
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 10:47
 * Version: v1.0
 */
public interface OrderService {

    Order createOrder(Long userId, Long productId);

}
