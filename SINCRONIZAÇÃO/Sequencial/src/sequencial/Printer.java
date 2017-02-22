/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequencial;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Amaro
 */
public class Printer {

    Semaphore[] s;
    int n;

    public Printer(int n) {
        this.n = n;
        s = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                s[i] = new Semaphore(1);
            } else {
                s[i] = new Semaphore(0);
            }
        }
    }
    
    
    public void deposit(int id) {
        s[id].acquireUninterruptibly();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

    }

    public void fetch(int id) {

        s[(id + 1) % n].release();

    }
}
