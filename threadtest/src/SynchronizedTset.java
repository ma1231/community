import java.util.concurrent.TimeUnit;

public class SynchronizedTset {

    public synchronized void syncMethod(){
        try {
            //System.out.println(Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedTset test=new SynchronizedTset();
        Thread t1= new Thread(){
            @Override
            public void run() {
                test.syncMethod();
            }
        };
        t1.start();

        TimeUnit.SECONDS.sleep(2);

        Thread t2= new Thread(){
            @Override
            public void run() {
                test.syncMethod();
            }
        };
        t2.start();

        t2.interrupt();
        System.out.println(t2.isInterrupted());
        System.out.println(t2.getState());
    }
}
