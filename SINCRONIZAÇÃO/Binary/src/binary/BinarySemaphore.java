/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
/**
 *
 * @author Amaro
 */
public class BinarySemaphore {
    AtomicInteger value;
    ConcurrentLinkedQueue queue;
    
    public BinarySemaphore(){
        value = new AtomicInteger(1);
        queue = new ConcurrentLinkedQueue();
}
    public void P(){
        if(!value.compareAndSet(1, 0))block();
    }
    
    public void V(){
        if(! queue.isEmpty()) unblock();
        else value.set(1);
    }
    
    private void block(){
        Thread t = Thread.currentThread();
        queue.add(t);
        t.suspend();
    }
    
    private void unblock(){
        Thread t = (Thread) queue.poll();
        if(t!= null) t.resume();
    }
}
