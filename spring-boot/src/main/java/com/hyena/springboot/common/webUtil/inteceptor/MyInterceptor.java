package com.hyena.springboot.common.webUtil.inteceptor;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;


@Log4j
@Component
public class MyInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            log.info("headerNames: " + name);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
        Object lock = new Object();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    for (int i = 0; i < 10; i++) {
//                        if(!Thread.currentThread().isInterrupted()) {Thread.currentThread().sleep(1000);}
//                        System.out.println(i+1+"s");
//                        if (i == 5) {
//                            Thread.currentThread().interrupt();
//                        }
//                    }
//                } catch (InterruptedException e) {
//                    System.out.println(Thread.currentThread().isInterrupted());
//                    synchronized (lock) {
//                        try {
//                            lock.wait();
//                            System.out.println("----waited");
//                        } catch (InterruptedException ex) {
//                            ex.printStackTrace();
//                        }
//                    }
//                }
//
//            }
//        }).start();

//        Thread.currentThread().sleep(10000);

        /**
         * Unsafe.getUnsafe() 只允许"直接调用方" 的类加载器为bootstrap加载器
         *
         * A -> B -> C(Reflection.getCallerClass() = A   but not B)
         */

    }



}
