/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testandset;

/**
 *
 * @author Amaro
 */
public class TestAndSet extends Thread{

  
   Lock lock;
   int id;

   public TestAndSet(Lock lock, int id) {
     this.lock = lock;
     this.id = id;
   }

   public void run() {

      while (true) {
         lock.requestCS(id);
         System.out.println("Thread-" + id + " is in CS");
         System.out.println("");
         // *** CASO A ***
         // try { Thread.sleep(200); } catch (Exception e) {}
         lock.releaseCS(id);
         // *** Inicial ***
         try { Thread.sleep(200); } catch (Exception e) {}
      }
   }

   public static void main (String[] args) {
     int nproc = 10;

     Lock lock = new LockImpl();
     for (int p = 0; p < nproc; p++)
        (new TestAndSet(lock, p)).start();         
   }
}