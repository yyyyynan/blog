package test.ThreadTask;

import java.util.concurrent.ArrayBlockingQueue;

public class threadtest {

    /**
     * 线程池的基本大小
     */
    static int corePoolSize = 10;
    /**
     * 线程池最大数量
     */
    static int maximumPoolSizeSize = 100;
    /**
     * 线程活动保持时间
     */
    static long keepAliveTime = 1;
    /**
     * 任务队列
     */
    static ArrayBlockingQueue workQueue = new ArrayBlockingQueue(10);


    public static void main(String[] args) {
        TicketOffice ticketOffice = new TicketOffice(new Object(), 1000);
        new Thread(ticketOffice, "窗口1").start();
        new Thread(ticketOffice, "窗口2").start();
        new Thread(ticketOffice, "窗口3").start();
//
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(
//                corePoolSize,
//                maximumPoolSizeSize,
//                keepAliveTime,
//                TimeUnit.SECONDS,
//                workQueue,
//                new ThreadFactoryBuilder().setNameFormat("XX-task-%d").build());
//
//        int[] ex = {10,60 , 30, 40, 50,20 , 70, 80, 90};
//        for (int i = 0; i < 9; i++) {
//            int s = i;
//            Object object = new Object();
//            executor.execute(() -> new Thread(new runnabletest(object,ex[s])).start());
//        }
//        executor.shutdown();
    }
}



