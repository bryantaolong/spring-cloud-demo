package com.bryan.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * ClassName: CustomGlobalFilter
 * Package: com.bryan.gateway.filter
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/13 - 9:10
 * Version: v1.0
 */
@Component
@Slf4j
public class CustomGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        String uri = request.getURI().getPath();
        long startTime = System.currentTimeMillis();

        log.info("uri: {}", uri);

        Mono<Void> filtered = chain.filter(exchange)
                .doFinally(result ->{
                    long endTime = System.currentTimeMillis();
                    long totalTime = endTime - startTime;
                    log.info("total time: {}", totalTime);
                });

        return filtered;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
