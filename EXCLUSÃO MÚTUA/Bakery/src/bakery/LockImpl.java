/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakery;

/**
 *
 * @author Amaro
 */
public class LockImpl implements Lock {

    volatile int N;
    volatile boolean[] choosing;
    volatile int[] number;

    public LockImpl(int nproc) {
        N = nproc;
        choosing = new boolean[N];
        number = new int[N];
        for (int j = 0; j < N; j++) {
            choosing[j] = false;
            number[j] = 0;

        }
    }

    public void requestCS(int i) {
        choosing[i] = true;
        for (int j = 0; j < N; j++) {
            if (number[j] > number[i]) {
                number[i] = number[j];
            }
        }
        number[i]++;
        choosing[i] = false;

        for (int j = 0; j < N; j++) {
            while (choosing[j]);
            while ((number[j] != 0)
                    && ((number[j] < number[i])
                    || ((number[j] == number[i]) && (j < i))));
        }
    }

    /*
 Garante a exclusão mútua
 Processos são independentes
 Não alternam a execução das seções críticas
 Processos não se bloqueiam mutuamente
 Não entram em deadlock
 Processos eventualmente podem entrar na
região crítica
 Em algum momento processo possui o menor
número
 Não gera starvation

     */
    public void releaseCS(int i) {
        number[i] = 0;
    }
}
