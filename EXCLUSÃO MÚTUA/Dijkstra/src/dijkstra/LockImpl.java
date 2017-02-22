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
public class LockImpl implements Lock{
    volatile int nproc, turn;
    volatile int[] status;
    
    public LockImpl(int n){
        nproc=n;
        turn=0;
        status = new int[n];
        for (int i = 0; i < n; i++) {
            status[i]=0;
        }
    }
    
    public void requestCS(int id){
        int j;
        
        do {
            status[id]=1;
            while (turn!=id) 
                if (status[turn] == 0) turn =id;
                status[id]=2;
                j=0;
                while ((j<nproc) && ((j==id) || (status[j]!=2))) 
                    j++;
        } while (j!= nproc);
        
        } 

    /*
Garante a exclusão mútua
 Processos são independentes
 Não alternam a execução das seções críticas
 Processos não se bloqueiam mutuamente
 Não entram em deadlock
 Processos podem esperar indefinidamente
 Pode acontecer starvation

    */
    
    public void releaseCS(int id){
        status[id]=0;
    }
}
