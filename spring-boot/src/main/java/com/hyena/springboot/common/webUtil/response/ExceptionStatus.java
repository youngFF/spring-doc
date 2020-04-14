package com.hyena.springboot.common.webUtil.response;

import lombok.Data;

@Data
public class ExceptionStatus {

    private static ExceptionStatus getInstance() {
        return new ExceptionStatus();
    }

    /**
     * 错误码
     */
    private String code;

    /**
     * 失败信息
     */
    private String msg;


    public static ExceptionStatus getExceptionStatus(String code,String msg) {
        ExceptionStatus status = getInstance();
        status.setCode(code);
        status.setMsg(msg);

        return status;
    }

}
