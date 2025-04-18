package com.bryan.business.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: StorageFeignClient
 * Package: com.bryan.business.client
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/13 - 11:09
 * Version: v1.0
 */
@FeignClient(value = "seata-storgae")
public interface StorageFeignClient {

    @GetMapping("/deduct")
    String deduct(@RequestParam("commodityCode") String commodityCode,
                         @RequestParam("count") Integer count);

}
