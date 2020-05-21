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
}
