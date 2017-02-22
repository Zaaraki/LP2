/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadcreator;

import java.lang.Thread;

/**
 *
 * @author Amaro
 */


public class ThreadCreator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Creating Threads");
        
        Thread thread1 = new Thread (new PrintTask("task 1"));
        Thread thread2 = new Thread (new PrintTask("task 2"));
        Thread thread3 = new Thread (new PrintTask("task 3"));
        
        System.out.println("Threads created, starting tasks");
        
        thread1.start();
        thread2.start();
        thread3.start();
        
        System.out.println("Tasks created, main ends. \n");
    }
    
}
