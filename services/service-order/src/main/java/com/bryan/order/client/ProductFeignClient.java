package com.bryan.order.client;

import com.bryan.model.product.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: ProductFiegnClient
 * Package: com.bryan.order.feign
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 15:47
 * Version: v1.0
 */
@Component
@FeignClient(value = "service-product", fallback = FallbackProductFeignClient.class)
public interface ProductFeignClient {

    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable("id") Long id);

}
