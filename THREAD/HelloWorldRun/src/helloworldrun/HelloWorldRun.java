/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldrun;

/**
 *
 * @author Zaaraki
 */

public class HelloWorldRun implements Runnable{
    public void run(){
        System.out.println("Hello World!");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HelloWorldRun h = new HelloWorldRun();
        Thread t = new Thread(h);
        t.start();
    }
    
}
