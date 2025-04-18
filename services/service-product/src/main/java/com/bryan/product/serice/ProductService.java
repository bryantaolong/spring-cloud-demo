package com.bryan.product.serice;

import com.bryan.model.product.Product;

/**
 * ClassName: ProductService
 * Package: com.bryan.product.serice
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 10:35
 * Version: v1.0
 */
public interface ProductService {

    Product getProductById(Long productId);

}
