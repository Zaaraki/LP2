/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylock2;

/**
 *
 * @author Amaro
 */
public class LockImpl implements Lock{
    int turn=0;
    
    public void requestCS(int id){
        while(turn == 1 -id); 
    }
    
    /*
    Processos dependentes, alternam as execuções das suas seções críticas
    Um processo pode bloquear ou atrasar o outro
    */
    
    public void releaseCS(int id){
        turn=1-id;
    }
}
