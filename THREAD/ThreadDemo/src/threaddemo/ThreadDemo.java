/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threaddemo;

/**
 *
 * @author Amaro
 */

class MyThread extends Thread{
    private String message;
    
    public MyThread(String m) {
        message = m;
    }
    
    public void run(){
        for (int r=0; r<10; r++){
            System.out.println(message);
        }
    }
    
}
public class ThreadDemo {

    public static void main(String[] args) {
        MyThread t1, t2;
        t1 = new MyThread("Primeiro Thread");
        t2 = new MyThread("Segundo Thread");
        t1.start();
        t2.start();
    }
    
}
