package com.yitu2.demo.constant;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 线程常量池
 * @author Administrator
 */
public class BasicConstant {
    /**
     * 线程池的基本大小
     */
    public static int corePoolSize = 10;
    /**
     * 线程池最大数量
     */
    public static int maximumPoolSizeSize = 300;
    /**
     * 线程活动保持时间
     */
    public static long keepAliveTime = 1;
    /**
     * 任务队列
     */
    public static ArrayBlockingQueue workQueue = new ArrayBlockingQueue(10);
}
