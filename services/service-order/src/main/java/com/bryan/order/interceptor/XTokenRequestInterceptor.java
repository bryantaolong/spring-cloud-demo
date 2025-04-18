package com.bryan.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * ClassName: XTokenInterceptor
 * Package: com.bryan.order.interceptor
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 17:08
 * Version: v1.0
 */
@Component
public class XTokenRequestInterceptor implements RequestInterceptor {

    /**
     * 请求拦截器
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("X-Token", "X-Token-Value");
    }
}
