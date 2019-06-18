package test.ThreadTask.Task;

/**
 * 题目:
 * 建立三个线程，A线程打印10次A，
 * B线程打印10次B,C线程打印10次C，
 * 要求线程同时运行，交替打印10次ABC。
 *
 * @author Administrator
 */
public class Task3 implements Runnable {
    private String name;
    private Object prev;
    private Object self;

    private Task3(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        for (int i = 0;i<10;i++){
            synchronized (prev) {
                synchronized (self){
                    System.out.print(name);
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            if (name == "A"){
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Task3 pa = new Task3("A",c,a);
        Task3 pb = new Task3("B",a,b);
        Task3 pc = new Task3("C",b,c);
        new Thread(pa).start();
//        Thread.sleep(100);
        new Thread(pb).start();
//        Thread.sleep(100);
        new Thread(pc).start();
//        Thread.sleep(100);
        System.out.println("程序运行时间：" + (System.currentTimeMillis() - startTime) + "ms");
    }
}
