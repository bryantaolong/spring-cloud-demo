package com.bryan.order.service.impl;

import com.bryan.order.bean.OrderTbl;
import com.bryan.order.client.AccountFeignClient;
import com.bryan.order.mapper.OrderTblMapper;
import com.bryan.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderTblMapper orderTblMapper;

    private final AccountFeignClient accountFeignClient;

    @Transactional
    @Override
    public OrderTbl create(String userId, String commodityCode, int orderCount) {
        //1、计算订单价格
        int orderMoney = calculate(commodityCode, orderCount);

        //TODO 2、扣减账户余额
        String result = accountFeignClient.debit(userId, orderMoney);

        //3、保存订单
        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setUserId(userId);
        orderTbl.setCommodityCode(commodityCode);
        orderTbl.setCount(orderCount);
        orderTbl.setMoney(orderMoney);

        orderTblMapper.insert(orderTbl);

        return orderTbl;
    }

    // 计算价格
    private int calculate(String commodityCode, int orderCount) {
        return 9 * orderCount;
    }

}
