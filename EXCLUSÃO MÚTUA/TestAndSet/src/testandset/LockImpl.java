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
public class LockImpl implements Lock{
    TSL flag = new TSL();
    
    public void requestCS(int i){
        while(flag.testAndSet());
    }
    
    public void releaseCS(int i){
        flag.unlock();
    }
    
    
    /*
    Garante a exclusão mútua
 Processos são independentes
 Não alternam a execução das seções críticas
 Processos não se bloqueiam mutuamente
 Não entram em deadlock
 Processos podem esperar indefinidamente
 Pode acontecer starvatio
    */
    
}
