package com.hyena.springboot.common.webUtil.response;

import lombok.Data;

@Data
public class JsonCommonResponse<T> {

    /**
     * 状态码：1成功 0失败
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    public static JsonCommonResponse success() {
        JsonCommonResponse response = new JsonCommonResponse(1, "", null);
        return response;
    }

    public static <T> JsonCommonResponse success(T data) {
        JsonCommonResponse response = new JsonCommonResponse(1, "", data);
        return response;
    }

    public static JsonCommonResponse failRes() {
        JsonCommonResponse response = new JsonCommonResponse(0, "", null);
        return response;
    }

    public static JsonCommonResponse failRes(Integer code, String msg) {
        JsonCommonResponse response = new JsonCommonResponse(code, msg, null);
        return response;
    }


    public JsonCommonResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


}
