package lock;

import java.util.concurrent.TimeUnit;

public class BooleanLockTest implements Runnable{

    static final BooleanLockTest test=new BooleanLockTest();
    private final Lock lock=new BooleanLock();

    public void syncMethod(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread()+"获得锁");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread()+"释放锁");
            lock.unlock();
        }
    }



    public static void main(String[] args) {
        for (int i=1;i<11;i++){
            new Thread(test).start();
        }
    }



    @Override
    public void run() {
        test.syncMethod();
    }
}
