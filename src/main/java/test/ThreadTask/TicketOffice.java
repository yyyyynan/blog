package test.ThreadTask;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 卖票多线程测试 传入的object为锁的对象 ticketNum为票数
 *
 * @author Administrator
 */

public class TicketOffice implements Runnable {

    private Object object;

    private int ticketNum;

    BlockingQueue<String> queue;

    public TicketOffice(java.lang.Object object, int ticketNum) {
        this.object = object;
        this.ticketNum = ticketNum;
        this.queue = new ArrayBlockingQueue<>(ticketNum);
        for (int i = 0; i < ticketNum; i++) {
            try {
                queue.put("" + (ticketNum-i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                int i = new Random().nextInt(50) + 2;
                Thread.sleep(10);
//                Thread.sleep(i * 100);
                System.out.println(Thread.currentThread().getName() + "卖出了一张票，剩余" + queue.take() + "张票"+i);
                if (queue.isEmpty()){
                    System.out.println(Thread.currentThread().getName() + "没有票了");
                    Thread.currentThread().stop();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}