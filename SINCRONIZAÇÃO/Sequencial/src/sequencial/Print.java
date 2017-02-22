/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequencial;

/**
 *
 * @author Amaro
 */
public class Print extends Thread{
    int id;
    Printer p;
    int i;
    
    public Print(int id, Printer p){
        this.id=id;
        this.p=p;
    }
    
    public void run(){
            
        while (true) {
            p.deposit(id);
            System.out.println(id);
            p.fetch(id);
        }
    }
}
