package com.bryan.business.controller;

import com.bryan.business.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PurchaseRestController {

    private final BusinessService businessService;

    /**
     * 购买
     *
     * @param userId        用户ID
     * @param commodityCode 商品编码
     * @param orderCount    数量
     * @return
     */
    @GetMapping("/purchase")
    public String purchase(@RequestParam("userId") String userId,
                           @RequestParam("commodityCode") String commodityCode,
                           @RequestParam("count") int orderCount) {
        businessService.purchase(userId, commodityCode, orderCount);
        return "business purchase success";
    }

}
