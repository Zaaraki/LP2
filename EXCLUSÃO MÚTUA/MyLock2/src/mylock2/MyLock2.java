/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylock2;

/**
 *
 * @author Amaro
 */
public class MyLock2 extends Thread{

    Lock lock;
    int id;
    
    public MyLock2(Lock lock, int id){
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
     MyLock2 t1 = new MyLock2(lock, 0);
     MyLock2 t2 = new MyLock2(lock, 1);
     t1.start();
     t2.start();
    }
    
}
