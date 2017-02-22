/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

/**
 *
 * @author Amaro
 */
public class Dijkstra extends Thread{

    Lock lock;
    int id;
    
    public Dijkstra(Lock lock, int id){
        this.lock=lock;
        this.id=id;
    }
    
    public void run(){
        while (true) {
            lock.requestCS(id);
            System.out.println("Thread-" + id + " is in CS");
            System.out.println(""); 
            lock.releaseCS(id);
        }
    }
    public static void main(String[] args) {
        int nproc = 10;

     Lock lock = new LockImpl(nproc);
     for (int p = 0; p < nproc; p++)
        (new Dijkstra(lock, p)).start();         
   }
}