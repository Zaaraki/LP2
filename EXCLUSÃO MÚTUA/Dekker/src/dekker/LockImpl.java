/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dekker;

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
        while(wantCS[otherId]){
            if(turn==otherId){
                wantCS[id] = false;
                while (turn==otherId);    
                wantCS[id] = true;
            
        }
        } 
    }
    
    /*
    Garante a exclusão mútua
 Processos são independentes
 Não alternam a execução das seções críticas
 Processos não se bloqueiam mutuamente
 Não entram em deadlock

    */
    
    public void releaseCS(int id){
        turn = 1-id;
        wantCS[id] = false;
    }
}
