package test.ThreadTask.Task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *  数组阻塞队列的使用
 *  一个线程添加数据仅队列
 *  另一个线程将数据取出处理
 * @author Administrator
 */
public class Task4 {

}

class BlockingQueueExample {

    public static void main(String[] args) throws Exception {

        BlockingQueue queue = new ArrayBlockingQueue(1024);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
//        Thread.sleep(4000);
        new Thread(consumer).start();


    }
}

class Producer implements Runnable{

    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (true){
                queue.put(i);
                Thread.sleep(100*i);
                i++;
                if (i == 100){
                    break;
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{

    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true){
                System.out.println(queue.take());
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}