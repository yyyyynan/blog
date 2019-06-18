package test.ThreadTask.Task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 题目：
 *  现有的程序代码模拟产生了16个日志对象，并且需要运行16秒才能打印完这些日志，
 *  请在程序中增加4个线程去调用parseLog()方法来分头打印这16个日志对象，
 *  程序只需要运行4秒即可打印完这些日志对象。
 * @author Administrator
 */
public class Task1Answer {
    public static void main(String[] args) {
        long starttim = System.currentTimeMillis();
        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(16);
        //启动4个线程
        for(int i = 0; i < 4; i++){
            new Thread(new Runnable(){
                @Override
                public void run() {
                    //不断从阻塞队列中取出数据并打印
                    while(true){
                        String log;
                        try {
                            log = queue.take();
                            parseLog(log);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

            }).start();
        }
        for (int i = 0; i < 16; i++) { // 这行代码不能改动
            final String log = "" + (i + 1);// 这行代码不能改动,生成的日志信息
            {
                try {
                    queue.put(log);                //将日志信息放入阻塞队列
                    //Test.parseLog(log);            //打印日志信息
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(System.currentTimeMillis()-starttim);
    }
    // parseLog方法内部的代码不能改动
    public static void parseLog(String log) {
        System.out.println(Thread.currentThread().getName()+": "+log + ":" + (System.currentTimeMillis() / 1000));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
