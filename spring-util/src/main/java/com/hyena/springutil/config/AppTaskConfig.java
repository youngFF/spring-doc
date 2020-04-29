package com.hyena.springutil.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * 任务每1秒执行一次
 */
@Configuration
public class AppTaskConfig {


    @Scheduled(cron = "0/1 * * ? * * ")
    public void myTask() {
        System.out.println(Thread.currentThread().getName()  + " " + System.currentTimeMillis());
    }

}
