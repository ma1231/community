package producerandconsumer;

import java.util.LinkedList;

public class EventQueue {

    private final int max=10;
    static class Event{}

    private final LinkedList<Event> evevtQueue=new LinkedList<>();


    public void offer(Event event){
        synchronized (evevtQueue){
           while(evevtQueue.size()>=max){
                try {
                    System.out.println("Queue is full");
                    evevtQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("event is submitted");
            evevtQueue.addLast(event);
            evevtQueue.notifyAll();
        }
    }

    public Event take(){
        synchronized (evevtQueue){
           while(evevtQueue.isEmpty()){
                try {
                    System.out.println("Queue is empty");
                    evevtQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = evevtQueue.removeFirst();
            evevtQueue.notifyAll();
            System.out.println("event is handled");
            return event;
        }
     }

}
