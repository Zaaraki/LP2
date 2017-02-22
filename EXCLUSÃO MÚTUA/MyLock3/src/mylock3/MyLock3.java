/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylock3;

/**
 *
 * @author Amaro
 */
public class MyLock3 extends Thread{
    
    Lock lock;
    int id;
    
    public MyLock3(Lock lock, int id){
        this.lock=lock;
        this.id=id;
    }
    
    public void run(){
        while (true) {
            lock.requestCS(id);
            System.out.println("Thread-" + id + " is in CS");
            System.out.println("");
            lock.releaseCS(id);
        }
    }
    
    public static void main(String[] args) {
        Lock lock = new LockImpl();
        MyLock3 t1 = new MyLock3(lock, 0);
        MyLock3 t2 = new MyLock3(lock, 1);
        t1.start();
        t2.start();
    }
    
}
