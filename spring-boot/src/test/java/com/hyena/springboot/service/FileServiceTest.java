package com.hyena.springboot.service;

import com.hyena.springboot.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

public class FileServiceTest extends BaseTest {

    @Autowired
    private FileService fileService;


    /**
     * 测试目标：文件正确分隔
     * 测试参数：
     *      fileName
     *      blockNum 3
     * 测试结果：
     */
    @Test
    public void splitFileTest() {
        fileService.splitFile(new File("/Users/yangxingdong/package-lock.json"), 10);
    }

    public static void main(String[] args) throws Exception
    {
        Thread t = new Thread(()->{
            try {
                // haha，睡觉时被打断，很形象 。 interrupted while sleeping
                Thread.sleep(1000000);
            } catch (Exception e) {
                System.out.println("...");
            }
        });

        t.start();


        Thread.sleep(2000);
        System.out.println("after sleep");
        t.interrupt();

    }
}
