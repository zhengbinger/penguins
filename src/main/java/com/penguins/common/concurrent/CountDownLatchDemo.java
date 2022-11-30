package com.penguins.common.concurrent;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/11/29 14:38
 **/
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        wait4();
    }

    public static void game() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        String[] all = new String[10];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int k = i;
            service.submit(() -> {
                for (int j = 0; j <= 100; j++) {
                    try {
                        Thread.sleep(random.nextInt(100));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    all[k] = j + "%";
                }

                countDownLatch.countDown();
                System.out.println(Arrays.toString(all));
            });

        }

        System.out.println("\t game start...");
        countDownLatch.await();
        System.out.println("\n game over ...");
        service.shutdown();
    }

    public static void wait4() {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(4);

        service.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "...start...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + "...end..." + countDownLatch.getCount());
        });

        service.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "...start...");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + "...end..." + countDownLatch.getCount());
        });

        service.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "...start...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + "...end..." + countDownLatch.getCount());
        });

        service.submit(() -> {

            try {
                System.out.println(Thread.currentThread().getName() + "...waiting...");
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName() + "...start..." + countDownLatch.getCount());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                service.shutdown();
            }

        });
    }
}
