package com.hyena.springboot.service;

import java.io.File;

/**
 * 文件操作服务
 */
public interface FileService {


    /**
     * split file
     *
     * @param fileName  file name
     * @param blockNum  designate block num ,don't split file if blockNum equal/less equal 0
     * @return the spitted block num, -1 if split failed
     *
     * @throws java.io.FileNotFoundException file dont't exist
     * @throws RuntimeException block num equals or less equals 0
     * @throws NullPointerException fileName null
     */
    int splitFile(File fileName, int blockNum);

}
