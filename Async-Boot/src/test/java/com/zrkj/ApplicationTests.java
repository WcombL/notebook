package com.zrkj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private Task task;

    @Autowired
    private AsyncTask asyncTask;

    @Autowired
    private PoolAsyncTask poolAsyncTask;

    @Test
    // 同步调用
    public void test() throws Exception {
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
    }

    @Test
    // 异步调用
    public void testAsync() throws Exception {

        long start = System.currentTimeMillis();

        Future<String> task1 = asyncTask.doTaskOne();
        Future<String> task2 = asyncTask.doTaskTwo();
        Future<String> task3 = asyncTask.doTaskThree();

        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

    @Test
    // 使用线程池异步调用
    public void test3() throws Exception {
        poolAsyncTask.doTaskOne();
        poolAsyncTask.doTaskTwo();
        poolAsyncTask.doTaskThree();

        Thread.currentThread().join();
    }
}
