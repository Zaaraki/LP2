/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mulmatrizthread;

/**
 *
 * @author -Amaro'TonyTony'Neto
 */
public class Multiplicador extends Thread{
    
    private int n;
    private int i;
    private int j;
    private int a[][];
    private int b[][];
    private int c[][];
    
    public Multiplicador(int i, int j, int n, int a[][], int b[][], int c[][]){
        this.i=i;
        this.j=j;
        this.n=n;
        this.a=a;
        this.b=b;
        this.c=c;
    }
    
    public void run(){
        int sm, k;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                sm = 0;
                for (k = 0; k < n; k++) {
                    
                    sm = sm + (a[i][k] * b[k][j]);
                }
               
                c[i][j] = sm;
            }
        }
    }
}
