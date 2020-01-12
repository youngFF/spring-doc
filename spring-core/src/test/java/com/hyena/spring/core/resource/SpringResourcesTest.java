package com.hyena.spring.core.resource;

import com.hyena.spring.core.base.BaseTest;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;

public class SpringResourcesTest extends BaseTest {

    //----- UrlResource Test ------//

    /**
     * 测试目标：UrlResource类的使用
     * 测试数据：
     *      url http://www.baidu.com
     * 测试结果：
     *      positive
     * @throws IOException
     */
    @Test
    public void urlResourceTest() throws IOException {
        String url = "http://www.baidu.com";
        UrlResource urlResource = new UrlResource(url);
        result  = urlResource.contentLength();

    }

    /**
     * 测试目标：url去掉协议
     * 测试数据：
     *      url www.baidu.com
     * 测试结果：
     *      negative
     *
     * @throws IOException
     */
    @Test
    public void urlResourceTest1() throws IOException {
        String url = "www.baidu.com";
        UrlResource urlResource = new UrlResource(url);
        result = urlResource.getInputStream();
    }


    /**
     * 测试目标：使用classpath作为协议
     * 测试数据：
     *      url classpath:spring/spring-config.xml
     * 测试结果：
     *      negative
     * @throws IOException
     */
    @Test
    public void urlResourceTest2() throws IOException {
        String url = "classpath:spring/spring-config.xml";
        UrlResource urlResource = new UrlResource(url);
        result = urlResource.getInputStream();
    }

    //----- UrlResource Test end------//

    //------ClasspathResource test -----//
    /**
     * 测试目标：ClassPathResource使用方式
     * 测试数据：
     *      url spring/spring-config.xml
     * 测试结果：
     *      positive
     * @throws IOException
     */
    @Test
    public void classpathResourceTest() throws IOException {
        String url = "spring/spring-config.xml";
        ClassPathResource resource = new ClassPathResource(url);
        result = resource.getInputStream();
    }

    /**
     * 测试目标：路径添加classpath:
     * 测试数据：
     *      url spring/spring-config.xml
     * 测试结果：
     *      negative
     * @throws IOException
     */
    @Test
    public void classpathResourceTest1() throws IOException {
        String url = "classpath:spring/spring-config.xml";
        ClassPathResource resource = new ClassPathResource(url);
        result = resource.getInputStream();
    }

    //------ClasspathResource test end-----//

    // ------------ fileSystemResource test ---//

    /**
     * 测试目标：FileSystemResource类的使用
     * 测试数据：
     *      file /usr/local
     * 测试结果：
     *      negative
     *      说明：/usr/local is a directory not a file
     * @throws IOException
     */
    @Test
    public void fileSystemResourceTest() throws IOException {
        String file = "/usr/local";
        FileSystemResource resource = new FileSystemResource(file);
        result = resource.getInputStream();
    }


    /**
     * 测试目标：资源路径使用文件而不是目录
     * 测试数据：
     *      file /etc/passwd
     * 测试结果：
     *      positive
     * @throws IOException
     */
    @Test
    public void fileSystemResourceTest2() throws IOException {
        String file = "/etc/passwd";
        FileSystemResource resource = new FileSystemResource(file);
        result = resource.getInputStream();
    }


    /**
     * 测试目标：资源路径使用url
     * 测试数据：
     *      path http://www.baidu.com
     * 测试结果：
     *      negative
     * @throws IOException
     */
    @Test
    public void fileSystemResourceTest3() throws IOException {
        String path = "http://www.baidu.com";
        FileSystemResource resource = new FileSystemResource(path);
        result = resource.getInputStream();
    }

    // ------------ fileSystemResource test end---//

}
