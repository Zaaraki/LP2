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
public class MyLock extends Thread{
    Lock lock;
    
    public MyLock(Lock lock){
        this.lock=lock;
    }
    
    public void run(){
        while (true) {
            lock.requestCS();
            System.out.println(getName() + " esta em CS");
            System.out.println("");
            lock.releaseCS();
        }
    }
}
