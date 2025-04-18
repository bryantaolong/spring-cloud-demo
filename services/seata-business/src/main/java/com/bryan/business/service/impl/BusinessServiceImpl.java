package com.bryan.business.service.impl;

import com.bryan.business.client.OrderFeignClient;
import com.bryan.business.client.StorageFeignClient;
import com.bryan.business.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.apache.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BusinessServiceImpl implements BusinessService {

    private final StorageFeignClient storageFeignClient;

    private final OrderFeignClient orderFeignClient;

    @GlobalTransactional
    @Override
    public void purchase(String userId, String commodityCode, int orderCount) {
        //TODO 1. 扣减库存
        String result = storageFeignClient.deduct(commodityCode, orderCount);

        //TODO 2. 创建订单
        orderFeignClient.create(userId, commodityCode, orderCount);

    }
}
