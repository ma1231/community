package lock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class BooleanLock implements Lock {

    private Thread currenThread;

    private boolean locked=false;

    private final List<Thread> blockedList=new ArrayList<>();


    @Override
    public void lock() throws InterruptedException {
        synchronized (this){
            while (locked){
                blockedList.add(currentThread());
                this.wait();
            }
            blockedList.remove(currentThread());
            this.locked=true;
            this.currenThread=currentThread();
        }
    }


    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this){
            if(mills<=0){
                this.lock();
            }else {
                long remainingMills= mills;
                long endMills=System.currentTimeMillis()+remainingMills;
                while(locked){
                    if(remainingMills<=0)
                        throw new TimeoutException("无法在指定时间获取锁");
                    if(!blockedList.contains(currentThread()))
                        blockedList.add(currentThread());
                    this.wait(remainingMills);
                    remainingMills=endMills-System.currentTimeMillis();
                }
                blockedList.remove(currentThread());
                this.locked=true;
                this.currenThread=currentThread();
            }
        }
    }

    @Override
    public void unlock() {
        synchronized (this){
            if(currenThread==currentThread()){
                this.locked=false;
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockcedThreads() {
        return Collections.unmodifiableList(blockedList);
    }

    private Thread currentThread() {
        return Thread.currentThread();
    }
}
