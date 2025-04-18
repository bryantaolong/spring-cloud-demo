package com.bryan.product.controller;

import com.bryan.model.product.Product;
import com.bryan.product.serice.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ProductController
 * Package: com.bryan.product.controller
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 10:30
 * Version: v1.0
 */
@Slf4j
@RestController
//@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        log.info("Get product by id: {}", id);

        Product product = productService.getProductById(id);
        return product;
    }

}
