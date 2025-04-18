package com.bryan.gateway.predicate;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * ClassName: CustomRoutePredicateFactory
 * Package: com.bryan.gateway.predicate
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/12 - 21:01
 * Version: v1.0
 */
public class CustomRoutePredicateFactory extends AbstractRoutePredicateFactory<CustomRoutePredicateFactory.Config> {

    private static final String PARAM_KEY = "param";

    private static final String VALUE_KEY = "value";

    public CustomRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(PARAM_KEY, VALUE_KEY);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange exchange) {
                ServerHttpRequest request = exchange.getRequest();
                String param = request.getQueryParams().getFirst(config.param);
                return StringUtils.hasText(param) && param.equals(config.value);
            }
        };
    }

    /**
     * 可配置的参数
     */
    @Validated
    public static class Config {

        @NotEmpty
        private String param;

        @NotEmpty
        private String value;

        public @NotEmpty String getParam() {
            return param;
        }

        public void setParam(@NotEmpty String param) {
            this.param = param;
        }

        public @NotEmpty String getValue() {
            return value;
        }

        public void setValue(@NotEmpty String value) {
            this.value = value;
        }
    }

}
