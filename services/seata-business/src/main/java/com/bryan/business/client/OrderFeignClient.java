package com.bryan.business.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: OrderFeignClient
 * Package: com.bryan.business.client
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/13 - 11:16
 * Version: v1.0
 */
@FeignClient(value = "seata-order")
public interface OrderFeignClient {

    @GetMapping("/create")
    String create(@RequestParam("userId") String userId,
                  @RequestParam("commodityCode") String commodityCode,
                  @RequestParam("count") int orderCount);

}
