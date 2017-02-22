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
public class LockImpl implements Lock{
    boolean wantCS[] = {false, false};
    int turn=1;
    
    public void requestCS(int id){
        int otherId = 1-id;
        wantCS[id] = true;
        turn=otherId;
        while(wantCS[otherId] && turn==otherId);
        } 

    /*
 Garante a exclusão mútua
 Processos são independentes
 Não alternam a execução das seções críticas
 Processos não se bloqueiam mutuamente
 Não entram em deadlock

    */
    
    public void releaseCS(int id){
        wantCS[id] = false;
    }
}
