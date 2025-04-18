package com.bryan.order.exception.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bryan.model.common.BaseResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

/**
 * ClassName: WebBlockExceptionHandler
 * Package: com.bryan.order.exception.handler
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/11 - 9:51
 * Version: v1.0
 */
@Component
public class SentinelBlockExceptionHandler implements BlockExceptionHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String s, BlockException e) throws Exception {
        httpServletResponse.setStatus(429);

        PrintWriter writer = httpServletResponse.getWriter();
        httpServletResponse.setContentType("application/json;charset=utf-8");

        BaseResponse response = BaseResponse.error(500, e.getClass().getSimpleName());

        String json = objectMapper.writeValueAsString(response);

        writer.write(json);
        writer.flush();
        writer.close();
    }
}
