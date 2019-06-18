package test.ThreadTask.Task;

/**
 * 题目:
 * 现成程序中的Test类中的代码在不断地产生数据，
 * 然后交给TestDo.doSome()方法去处理，
 * 就好像生产者在不断地产生数据，消费者在不断消费数据。
 * 请将程序改造成有10个线程来消费生成者产生的数据，
 * 这些消费者都调用TestDo.doSome()方法去进行处理，
 * 故每个消费者都需要一秒才能处理完，
 * 程序应保证这些消费者线程依次有序地消费数据，
 * 只有上一个消费者消费完后，下一个消费者才能消费数据，
 * 下一个消费者是谁都可以，
 * 但要保证这些消费者线程拿到的数据是有顺序的。
 *
 * @author Administrator
 */
public class Task2 implements Runnable {

    public static void main(String[] args) {

    }

    Object object;

    public Task2(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {

        }
    }
}

