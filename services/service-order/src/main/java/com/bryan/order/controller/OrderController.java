package com.bryan.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bryan.model.order.Order;
import com.bryan.order.config.properties.OrderProperties;
import com.bryan.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: OrderController
 * Package: com.bryan.order.controller
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 10:43
 * Version: v1.0
 */
@Slf4j
//@RefreshScope // 自动刷新
@RestController
//@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    /**
     *
     * @param userId 用户 ID
     * @param productId 产品 ID
     * @return 订单
     */
    @GetMapping("/create")
    public Order createOrder(@RequestParam Long userId,
                             @RequestParam Long productId) {
        log.info("create order userId: {}, productId: {}", userId, productId);
        return orderService.createOrder(userId, productId);
    }

    /**
     *
     * @param userId 用户 ID
     * @param productId 产品 ID
     * @return 订单
     */
    @SentinelResource(value = "secKill", blockHandler = "secKillFallBack")
    @GetMapping("/secKill")
    public Order secKill(@RequestParam Long userId,
                         @RequestParam Long productId) {
        log.info("sec kill order userId: {}, productId: {}", userId, productId);

        Order order = orderService.createOrder(userId, productId);
        order.setId(Long.MAX_VALUE);

        return order;
    }

    public Order secKillFallback(Long userId,Long productId, BlockException e){
        System.out.println("secKillFallback....");

        Order order = new Order();
        order.setId(productId);
        order.setUserId(userId);
        order.setAddress("异常信息：" + e.getClass());

        return order;
    }

    /**
     *
     * @return String
     */
    @GetMapping("/write")
    public String write() {
        return "write";
    }

    /**
     *
     * @return String
     */
    @GetMapping("/read")
    public String read() {
        return "read";
    }

//    @Value("${order.timeout}")
//    private String orderTimeout;
//
//    @Value("${order.auto-confirm}")
//    private String orderAutoConfirm;

    @Autowired
    OrderProperties orderProperties;

    /**
     *
     * @return String
     */
    @GetMapping("/config")
    public String config(){
        return "order.timeout="+orderProperties.getTimeout()+"； " +
                "order.auto-confirm="+orderProperties.getAutoConfirm() +"；"+
                "order.db-url="+orderProperties.getDbUrl();
    }

}
