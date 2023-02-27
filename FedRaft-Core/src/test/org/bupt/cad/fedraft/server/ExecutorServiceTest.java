package org.bupt.cad.fedraft.server;


import org.bupt.cad.fedraft.config.Configuration;
import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.*;

public class ExecutorServiceTest {
    public static HashMap<Integer, ScheduledExecutorService> hashMap2 = new HashMap<>();
    public static HashMap<Integer, ScheduledFuture<?>> hashMap3 = new HashMap<>();
    static class Heartbeat2 extends Thread{

        int id;

        public Heartbeat2(int id){
            this.id = id;
        }

        @Override
        public void run() {
            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.scheduleAtFixedRate(() -> {
                //do sth
                int sum = 0;
                for (int i = 0; i < 100000; i++) {
                    sum += i;
                }
                System.out.println(System.currentTimeMillis()  + " | " + sum);
            }, 0, 1000, TimeUnit.MILLISECONDS);
            hashMap2.put(id, executorService);
            System.out.println(System.currentTimeMillis() + "当前心跳信息终止了");

//            while (true) {
//                int sum = 0;
//                for (int i = 0; i < 100000; i++) {
//                    sum += i;
//                }
//                System.out.println(System.currentTimeMillis()  + " | ");
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }


    @Test
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService
                = Executors.newScheduledThreadPool(Configuration.getInt(Configuration.MANAGER_THREADPOOL_NUMBERS));
        for (int i = 0; i < 3; i++) {
            ScheduledFuture<?> scheduledFuture =
                    scheduledExecutorService.scheduleAtFixedRate(()->{
                        int sum = 0;
                        for (int j = 0; j < 100000; j++) {
                            sum += j;
                        }
                        System.out.println(System.currentTimeMillis()  + " | " + sum);
                    }, 0, 1000, TimeUnit.MILLISECONDS);
            hashMap3.put(i, scheduledFuture);
        }
        try {
            new CountDownLatch(1).await(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < 3; i++) {
            hashMap3.get(i).cancel(true);
            System.out.println("??????3333");
        }
//        scheduledExecutorService.shutdown();
//        HashMap<Integer, Future<?>> hashMap = new HashMap<>();
//        for(int i = 0; i < 3; i++) {
//            Future<?> future = Runtime.executor.submit(new Heartbeat2(i));
//            hashMap.putIfAbsent(i, future);
//        }
//        try {
//            new CountDownLatch(1).await(3, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        for(int i = 0; i < 3; i++) {
////            hashMap.get(i).cancel(true);
//            System.out.println("??????111");//关闭外线程已经没有用了
//        }
//        try {
//            new CountDownLatch(1).await(2000, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        for(int i = 0; i < 3; i++) {
//            hashMap2.get(i).shutdown();
//            System.out.println("??????222");//关闭外线程已经没有用了
//        }
//        Runtime.executor.shutdown();
    }

}
