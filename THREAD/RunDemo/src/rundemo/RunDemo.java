/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rundemo;

/**
 *
 * @author Amaro
 */

class MyRun implements Runnable{
    private String message;
    public MyRun(String m){ message = m;}
    
    public void run(){
        for(int r=0; r<10; r++){
            System.out.println(message);
        }
    }

}
public class RunDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyRun r1, r2;
        Thread t1, t2;
        r1 = new MyRun("Primeiro Thread");
        r2 = new MyRun("Segundo Thread");
        t1 = new Thread(r1);
        t2 = new Thread(r2);
        t1.start();
        t2.start(); 
    }
    
}
