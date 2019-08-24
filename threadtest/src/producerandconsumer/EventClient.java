package producerandconsumer;

import java.util.concurrent.TimeUnit;

public class EventClient {

    public static void main(String[] args) {
        //EventClient eventClient = new EventClient();
        EventQueue eventQueue=new EventQueue();
        Thread t1 = new Thread("Producer") {
            @Override
            public void run() {
                for (; ; ) {
                    eventQueue.offer(new EventQueue.Event());
                }
            }
        };


        Thread t3 = new Thread("Producer2") {
            @Override
            public void run() {
                for (; ; ) {
                    eventQueue.offer(new EventQueue.Event());
                }
            }
        };

        Thread t2 = new Thread("Consumer"){
            @Override
            public void run() {
                for (; ; ) {
                    eventQueue.take();
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
    /*@Override
    public void run() {
        for(;;){
            eventQueue.offer(new EventQueue.Event());
        }

        for(;;){
            eventQueue.take();
        }
    }*/
    }
}


