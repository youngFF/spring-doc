package com.hyena.springboot.controller.aysnc;

import com.hyena.springboot.common.webUtil.response.JsonCommonResponse;
import com.hyena.springboot.controller.BaseController;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Callable;

@RequestMapping("/async")
@Log4j
@Controller
public class AsyncController extends BaseController {


    /**
     * 测试request异步请求
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/async" , method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Callable<String> asyncRequest(HttpServletRequest request, HttpServletResponse response) {
        log.info("thread Name: " + Thread.currentThread().getName() );
        response.setHeader("connection-type","keep-alive");

        return ()->{
            String threadName = Thread.currentThread().getName();
            Thread.sleep(1000);
            return threadName;
        };
    }


    /**
     * 测试同步请求
     * @return
     * @throws InterruptedException
     */
    @RequestMapping(value = "/sync", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public JsonCommonResponse<String> syncRequest() throws InterruptedException {
        log.info("thread name : " + Thread.currentThread().getName());

        for (int i = 0; i < 10; i++) {
            System.gc();
        }

        Thread.sleep(1000);

        return JsonCommonResponse.success();
    }



}
