package test.ThreadTask;

/**
 * 输出 1 2 A
 *     3 4 B
 *     ...
 * @author Administrator
 */
public class TicketOffice2 implements Runnable {
    private int NUM = 52;
    private Object object;

    public TicketOffice2(java.lang.Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM; i++) {
            synchronized (object) {
                System.out.print(i + 1 + " ");
                if ((i + 1) % 2 == 0) {
                    System.out.print((char) ('A' + (i / 2)) + "  ");
                    System.out.println();
                }
            }
        }
    }


}