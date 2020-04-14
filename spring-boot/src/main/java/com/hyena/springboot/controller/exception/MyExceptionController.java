package com.hyena.springboot.controller.exception;


import com.hyena.springboot.common.webUtil.response.ExceptionStatus;
import com.hyena.springboot.common.webUtil.response.JsonCommonResponse;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Log4j
public class MyExceptionController {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonCommonResponse<ExceptionStatus> runtimeExceptionHandler(HttpServletRequest request, HttpServletResponse response,
                                                                       Exception e) {

        log.info("MyExceptionController.runtimeExceptionHandler:" ,e);

        return JsonCommonResponse.success(ExceptionStatus.getExceptionStatus("500", e.getMessage()));
    }
}
