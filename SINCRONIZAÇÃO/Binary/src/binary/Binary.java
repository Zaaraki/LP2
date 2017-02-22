/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary;

/**
 *
 * @author Amaro
 */
public class Binary extends Thread{

    BinarySemaphore s;
    int id;
    
    public Binary(BinarySemaphore s, int id){
        this.s=s;
        this.id=id;
    }
   
    public void run(){
        while (true) {
            s.P();
            System.out.println("Thread-" + id + " is in CS");
         System.out.println("");
//         try { Thread.sleep(500); } catch (Exception e) {}
         s.V();
         /*** CASO A ***/
          try { Thread.sleep(500+100*id); } catch (Exception e) {}
      }
   }

   public static void main (String[] args) {
     int nproc = 10;

     BinarySemaphore s = new BinarySemaphore();
     for (int p = 0; p < nproc; p++)
        (new Binary(s, p)).start();         
   }
}