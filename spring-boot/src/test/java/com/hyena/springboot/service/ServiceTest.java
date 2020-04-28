package com.hyena.springboot.service;

import com.hyena.model.User;
import com.hyena.springboot.BaseTest;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
public class ServiceTest extends BaseTest {


    @Test
    public void test() {

        User user = new User();
        WeakReference<User> weakReference = new WeakReference<>(user);

        System.out.println(weakReference.get()==null);

        System.gc();

        System.out.println(weakReference.get()==null);

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("hello world");
        String s = threadLocal.get();
        System.out.println(s);

        System.gc();

        String p = threadLocal.get();
        System.out.println(p);



    }


    public static void main(String[] args) {
        AtomicInteger atomic = new AtomicInteger();
        atomic.incrementAndGet();

        new Thread(() ->
        {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.currentThread().sleep(1000);
                    System.out.println(atomic.incrementAndGet() +  "  " + Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();


        new Thread(() ->
        {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.currentThread().sleep(1000);
                    System.out.println(atomic.incrementAndGet() +  "  " + Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
