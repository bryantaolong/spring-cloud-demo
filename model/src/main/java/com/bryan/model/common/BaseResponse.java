package com.bryan.model.common;

import lombok.Data;

/**
 * ClassName: ErrorCode
 * Package: com.bryan.model.common
 * Description:
 * Author: Bryan Long
 * Create: 2025/2/11 - 10:01
 * Version: v1.0
 */
@Data
public class BaseResponse {

    private Integer code;

    private String message;

    private Object data;

    public static BaseResponse success() {
        BaseResponse response = new BaseResponse();

        response.setCode(200);
        response.setMessage("success");

        return response;
    }

    public static BaseResponse success(String msg, Object data) {
        BaseResponse response = new BaseResponse();

        response.setCode(200);
        response.setMessage(msg);
        response.setData(data);

        return response;
    }

    public static BaseResponse error() {
        BaseResponse response = new BaseResponse();

        response.setCode(500);
        response.setMessage("error");

        return response;
    }

    public static BaseResponse error(Integer code, String message) {
        BaseResponse response = new BaseResponse();

        response.setCode(code);
        response.setMessage(message);

        return response;
    }

}
