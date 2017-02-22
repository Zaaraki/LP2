/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poolthread;

import java.util.Random;
import java.util.concurrent.*;

/**
 *
 * @author Amaro
 */
public class PoolThread {

    public static void main(String[] args) {
        int n = 50, i, j, k, sm;
        int a[][] = new int[n][n];
        int b[][] = new int[n][n];
        int ab[][] = new int[n][n];
        long init;
        long end;
        long diff;

        Random r = new Random();

        /*POVOAR MATRIZ A*/
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = r.nextInt(10);
            }
        }

        /*POVOAR MATRIZ B*/
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                b[i][j] = r.nextInt(10);
            }
        }

        /*PRINTAR MATRIZ A*/
//        System.out.println("MATRIZ A");
//
//        for (i = 0; i < n; i++) {
//            for (j = 0; j < n; j++) {
//                System.out.printf("%d ", a[i][j]);
//            }
//            System.out.printf("\n");
//        }

        System.out.printf("\n");

        /*PRINTAR MATRIZ B*/
//        System.out.println("MATRIZ B");
//        for (i = 0; i < n; i++) {
//            for (j = 0; j < n; j++) {
//                System.out.printf("%d ", b[i][j]);
//            }
//            System.out.printf("\n");
//        }

        System.out.printf("\n");
        
        int nt=100;
        //ExecutorService e = Executors.newCachedThreadPool();
        ExecutorService e = Executors.newFixedThreadPool(nt);
        
        init = System.nanoTime();
        
        
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                e.execute(new Multiplicador(i, j, n, a, b, ab));
            }
        }
        
        e.shutdown();
        
        end = System.nanoTime();
        diff = end - init;

//        init = System.nanoTime();
//        /*CALCULAR A MATRIZ*/
//        
//         for (i = 0; i < n; i++) {
//            for (j = 0; j < n; j++) {
//         
//                Threads[i][j] = new Multiplicador(i, j, n, a, b, ab);
//                Threads[i][j].start();
//         
//            }
//         }
//         
//         for (i = 0; i < n; i++) {
//            for (j = 0; j < n; j++) {
//                try{
//                Threads[i][j].join();
//                }catch(InterruptedException e){}
//            }
//         }
//         
//         
//        end = System.nanoTime();
//        diff = end - init;
//        
//        
        /*PRINTAR MATRIZ AB*/
//        System.out.println("MATRIZ AB");
//        for (i = 0; i < n; i++) {
//            for (j = 0; j < n; j++) {
//                System.out.printf("%d ", ab[i][j]);
//            }
//            System.out.printf("\n");
//        }
        System.out.println("Demorou " + ((float)diff/100000000) + " Segundos");
    }

}
