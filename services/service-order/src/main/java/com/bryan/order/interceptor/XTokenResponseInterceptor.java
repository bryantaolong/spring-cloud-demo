package com.bryan.order.interceptor;

import feign.InvocationContext;
import feign.ResponseInterceptor;

/**
 * ClassName: XTokenResponseInterceptor
 * Package: com.bryan.order.interceptor
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/10 - 17:10
 * Version: v1.0
 */
public class XTokenResponseInterceptor implements ResponseInterceptor {

    @Override
    public Object intercept(InvocationContext invocationContext, Chain chain) throws Exception {
        return null;
    }

    @Override
    public ResponseInterceptor andThen(ResponseInterceptor nextInterceptor) {
        return ResponseInterceptor.super.andThen(nextInterceptor);
    }

    @Override
    public Chain apply(Chain chain) {
        return ResponseInterceptor.super.apply(chain);
    }
}
