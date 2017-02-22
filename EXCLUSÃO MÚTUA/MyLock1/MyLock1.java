/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylock1;

/**
 *
 * @author Amaro
 */
public class MyLock1{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Lock lock = new LockImpl();
        MyLock t1 = new MyLock(lock);
        MyLock t2 = new MyLock(lock);
        t1.start();
        t2.start();
    }
    
}
