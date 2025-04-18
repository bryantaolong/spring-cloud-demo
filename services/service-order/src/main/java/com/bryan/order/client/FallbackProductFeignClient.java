package com.bryan.order.client;

import com.bryan.model.product.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * ClassName: FallbackProductFeignClient
 * Package: com.bryan.order.client
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 17:18
 * Version: v1.0
 */
@Component
public class FallbackProductFeignClient implements ProductFeignClient {


    @Override
    public Product getProductById(Long id) {
        Product product = new Product();

        product.setId(id);
        product.setPrice(BigDecimal.valueOf(9_999_999));
        product.setProductName("Fallback Product");
        product.setNum(1);

        return product;
    }
}
