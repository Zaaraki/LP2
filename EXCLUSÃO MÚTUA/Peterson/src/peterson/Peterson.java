/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peterson;

/**
 *
 * @author Amaro
 */
public class Peterson extends Thread{
  Lock lock;
   int id;

   public Peterson(Lock lock, int id) {
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

   public static void main (String[] args) {
     Lock lock = new LockImpl();
     Peterson t1 = new Peterson(lock, 0);
     Peterson t2 = new Peterson(lock, 1);
     t1.start();
     t2.start();
   }
}