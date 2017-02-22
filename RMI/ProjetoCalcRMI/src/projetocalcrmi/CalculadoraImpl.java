/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocalcrmi;
import java.rmi.*;
import java.rmi.server.*;

/**
 *
 * @author Amaro
 */
public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora{
    protected CalculadoraImpl() throws RemoteException{
        super();
    }
    
    public long add(long a, long b)throws RemoteException{
        return a+b;
    }
}
