public class ThreadTest implements Runnable {


    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
        /*for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "abc");
        }*/
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        Thread t1 = new Thread(threadTest, "线程1");
        Thread t2 = new Thread(threadTest, "线程2");
        Thread t3 = new Thread(threadTest, "线程3");
        t1.start();
        t2.start();
        t3.start();
       /* for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "abc");
        }*/
    }
}
