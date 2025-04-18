package com.bryan.order.controller;

import com.bryan.order.bean.OrderTbl;
import com.bryan.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    /**
     * 创建订单
     *
     * @param userId
     * @param commodityCode
     * @param orderCount
     * @return
     */
    @GetMapping("/create")
    public String create(@RequestParam("userId") String userId,
                         @RequestParam("commodityCode") String commodityCode,
                         @RequestParam("count") int orderCount) {
        OrderTbl tbl = orderService.create(userId, commodityCode, orderCount);
        return "order create success = 订单id：【" + tbl.getId() + "】";
    }

}
