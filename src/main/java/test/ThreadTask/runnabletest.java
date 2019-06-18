package test.ThreadTask;

/**
 * @author Administrator
 */
public class runnabletest implements Runnable {

    private Object object;

    private int ex;

    public runnabletest(Object object, int ex) {
        super();
        this.object = object;
        this.ex = ex;
    }

    @Override
    public void run() {
        synchronized (object) {
            try {
                Thread.sleep(ex*20);
                System.out.println(ex);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
