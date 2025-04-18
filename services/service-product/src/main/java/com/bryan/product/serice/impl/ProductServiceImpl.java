package com.bryan.product.serice.impl;

import com.bryan.model.product.Product;
import com.bryan.product.serice.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * ClassName: ProductServiceImpl
 * Package: com.bryan.product.serice.impl
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 10:36
 * Version: v1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    /**
     * 根据 id 获取商品信息
     * @param productId
     * @return
     */
    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();

        product.setId(productId);
        product.setPrice(BigDecimal.valueOf(5999));
        product.setProductName("Apple Mac Mini M4");
        product.setNum(1);

        return product;
    }
}
