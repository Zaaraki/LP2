/**
 * *************************************************************************
 *
 * - Incial
 * Mostra que os threads executam sem starvation, sem espera ocupada e com
 * política de liberação justa. Porém, mostra que os threads parecem não
 * ser independentes, pois executm em uma sequencia repetitiva.
 *
 * - Caso A
 * Mostra que os threads são independentes.
 *
 * - Caso B - INICIAL
 * Mostra que a política de liberação não é justa.
 *
 ***************************************************************************
 */
package mylock;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Amaro
 */
public class MyLock extends Thread {

    Semaphore s;
    int id;

    public MyLock(Semaphore s, int id) {
        this.s = s;
        this.id = id;
    }

    public void run() {
        while (true) {
            try {
                s.acquire();
                System.out.println("Thread-" + id + " is in CS");
                System.out.println("");
                Thread.sleep(500);
                s.release();
                /**
                 * * CASO A **
                 */
//                 Thread.sleep(500+100*id);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        int nproc = 10;

        /**
         * * INICIAL **
         */
        Semaphore s = new Semaphore(1, true);
        /**
         * * CASO B **
         */
        // Semaphore s = new Semaphore(1);
        for (int p = 0; p < nproc; p++) {
            (new MyLock(s, p)).start();
        }
    }
}
