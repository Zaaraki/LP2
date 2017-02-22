/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylock1;

/**
 *
 * @author Amaro
 */
public class LockImpl implements Lock{
    boolean busy = false;
    
    public void requestCS(){
        while(busy);  //NÃO GARANTE EXCLUSÃO MÚTUA
        busy=true;
    }
    
    public void releaseCS(){
        busy=false;
    }
}
