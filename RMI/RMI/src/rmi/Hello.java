/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import java.rmi.server.*;
import java.rmi.*;
/**
 *
 * @author Amaro
 */
public class Hello extends UnicastRemoteObject implements HelloInterface{
    private String message;
    
    public String sayHello() throws RemoteException{
        return message;
    }
    
    public Hello (String msg) throws RemoteException{
        message=msg;
    }
    
}
