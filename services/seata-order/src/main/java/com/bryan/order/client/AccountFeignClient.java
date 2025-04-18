package com.bryan.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: AccountFeignClient
 * Package: com.bryan.order.client
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/13 - 11:25
 * Version: v1.0
 */
@FeignClient(value = "seata-account")
public interface AccountFeignClient {

    @GetMapping("/debit")
    String debit(@RequestParam("userId") String userId,
                 @RequestParam("money") int money);

}
