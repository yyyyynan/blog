package test.ThreadTask.Task;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.yitu2.demo.constant.BasicConstant;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.TimeUnit;

/**
 * 题目：
 * 现有的程序代码模拟产生了16个日志对象，并且需要运行16秒才能打印完这些日志，
 * 请在程序中增加4个线程去调用parseLog()方法来分头打印这16个日志对象，
 * 程序只需要运行4秒即可打印完这些日志对象。
 *
 * @author Administrator
 */
public class Task1 implements Runnable {


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                BasicConstant.corePoolSize,
                BasicConstant.maximumPoolSizeSize,
                BasicConstant.keepAliveTime,
                TimeUnit.SECONDS,
                BasicConstant.workQueue,
                new ThreadFactoryBuilder().setNameFormat("XX-task-%d").build());
        Task1 t = new Task1(new Object());
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> new Thread(t).start());
        }
        long endTime = System.currentTimeMillis();
        executor.shutdown();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

    private Object object;

    private int num = 1;

    public Task1(Object object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            try {
                for (int i = 0; i < 4; i++) {
                    if (num <= 16) {
                        System.out.println(Thread.currentThread().getName()+": "+num);
                    }
                    num++;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
