/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocalcrmi;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Amaro
 */
public class CalculadoraServer {
    CalculadoraServer(){
        try{
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Registry registry = LocateRegistry.getRegistry();
            Calculadora c = new CalculadoraImpl();
            Naming.bind("CalculadoraService", (Remote) c);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new CalculadoraServer();
        
    }
}
