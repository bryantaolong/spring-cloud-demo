package com.bryan.gateway.factory;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * ClassName: OneTimeTokenGatwayFactory
 * Package: com.bryan.gateway.factory
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/13 - 10:05
 * Version: v1.0
 */
@Component
public class OneTimeTokenGatewayFactory extends AbstractNameValueGatewayFilterFactory {

    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return new GatewayFilter() {

            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                    ServerHttpRequest request = exchange.getRequest();
                    HttpHeaders headers = request.getHeaders();

                    String value = headers.getFirst(config.getValue());
                    if (value.equals("uuid")) {
                        value = UUID.randomUUID().toString();
                    } else if(value.equals("jwt")) {
                        value = "eyEdad2443gsd.fafasfvc64y45y3.4ygwrgr";
                    }

                    headers.add(config.getName(), value);
                }));
            }

        };
    }
}
