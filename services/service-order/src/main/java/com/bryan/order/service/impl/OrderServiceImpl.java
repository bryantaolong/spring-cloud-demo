package com.bryan.order.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bryan.model.order.Order;
import com.bryan.model.product.Product;
import com.bryan.order.client.ProductFeignClient;
import com.bryan.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: OrderServiceImpl
 * Package: com.bryan.order.service.impl
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 10:48
 * Version: v1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final DiscoveryClient discoveryClient;

    private final RestTemplate restTemplate;

    private final LoadBalancerClient loadBalancerClient;

    private final ProductFeignClient productFeignClient;

    @SentinelResource(value = "createOrder", blockHandler = "createOrderFallback")
    @Override
    public Order createOrder(Long userId, Long productId) {
//        Product product = getProductFromRemote(productId); // 未使用负载均衡

//        Product product = getProductFromRemoteWithLoadBalance(productId); // 使用负载均衡

//        Product product = getProductFromRemoteWithLoadBalanceAnnotation(productId); // 基于注解的负载均衡

        Product product = productFeignClient.getProductById(productId);

        Order order = new Order();

        order.setId(1L);

        // 总金额
        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));

        order.setUserId(userId);
        order.setNickName("Bryan");
        order.setAddress("LA");

        // 远程查询商品列表
        order.setProductList(List.of(product));

        return order;
    }

    public Order createOrderFallback(Long userId, Long productId, BlockException e) {
        Order order = new Order();

        order.setId(0L);
        order.setTotalAmount(new BigDecimal("0"));
        order.setUserId(userId);
        order.setNickName("未知用户");
        order.setAddress("异常信息："+e.getClass());

        return order;
    }

    // 进阶1：完成远程发送请求
    private Product getProductFromRemote(Long productId) {
        log.info("Get product from Remote");

        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");

        ServiceInstance instance = instances.get(0);

        // 1. 构造 URL
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + productId;

        // 2. 发送请求
        log.info("Get product from Remote, url: " + url);
        return restTemplate.getForObject(url, Product.class);
    }

    // 进阶2：完成负载均衡发送请求
    private Product getProductFromRemoteWithLoadBalance(Long productId){
        //1、获取到商品服务所在的所有机器 IP+port
        ServiceInstance choose = loadBalancerClient.choose("service-product");
        //远程URL
        String url = "http://"+choose.getHost() +":" +choose.getPort() +"/product/"+productId;
        log.info("远程请求：{}",url);
        //2、给远程发送请求
        return restTemplate.getForObject(url, Product.class);
    }

    // 进阶3：基于注解的负载均衡
    private Product getProductFromRemoteWithLoadBalanceAnnotation(Long productId){

        String url = "http://service-product/product/"+productId;
        //2、给远程发送请求； service-product 会被动态替换
        return restTemplate.getForObject(url, Product.class);
    }

}
