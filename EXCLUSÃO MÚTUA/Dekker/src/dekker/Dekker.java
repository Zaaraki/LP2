/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dekker;

/**
 *
 * @author Amaro
 */
public class Dekker extends Thread {

    Lock lock;
    int id;

    public Dekker(Lock lock, int id) {
        this.lock = lock;
        this.id = id;
    }

    public void run() {

        while (true) {
            lock.requestCS(id);
            System.out.println("Thread-" + id + " is in CS");
            System.out.println("");
            lock.releaseCS(id);
            try { Thread.sleep(200); } catch (Exception e) {}
        }
    }

    public static void main(String[] args) {
        Lock lock = new LockImpl();
        Dekker t1 = new Dekker(lock, 0);
        Dekker t2 = new Dekker(lock, 1);
        t1.start();
        t2.start();
    }

}
