/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylock3;

/**
 *
 * @author Amaro
 */
public class LockImpl implements Lock{
    boolean wantCS[] = {false, false};
    
    public void requestCS(int id){
        wantCS[id] = true;
        while(wantCS[1-id]); 
    }
    
    /*
    Garante a exclusão mútua
 Não garante em Java sem a primitiva volatile
 Processos são independentes
 Não alternam a execução das seções críticas
 Processos podem ficar bloqueados (deadlock)

    */
    
    public void releaseCS(int id){
        wantCS[id] = false;
    }
}
