package test.ThreadTask;

/**
 * Created by nan on 2019/5/13
 */
public class ttttt implements Runnable {

        //共享资源(临界资源)
        static int i=0;

        /**
         * synchronized 修饰实例方法
         */
        public synchronized void increase(){
            i++;
        }
        @Override
        public void run() {
            for(int j=0;j<1000000;j++){
                increase();
            }
        }
        public static void main(String[] args) throws InterruptedException {
            long startTime = System.currentTimeMillis();
            ttttt instance=new ttttt();
            Thread t1=new Thread(instance);
            Thread t2=new Thread(instance);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println(i);
            long endTime = System.currentTimeMillis();    //获取结束时间
            System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        }

}
