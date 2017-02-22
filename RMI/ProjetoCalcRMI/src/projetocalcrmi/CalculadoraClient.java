/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocalcrmi;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

/**
 *
 * @author Amaro
 */
public class CalculadoraClient {
    public static void main(String[] args) {
        try{
            System.setProperty("java.security.policy", "E:\\Zaaraki\\CIÊNCIAS DA COMPUTAÇÃO\\4º PERÍODO\\LP2\\CÓDIGOS TREINO\\RMI\\ProjetoCalcRMI\\src\\projetocalcrmi\\client.policy");
            System.setSecurityManager(new RMISecurityManager());
            Calculadora c = (Calculadora) Naming.lookup("rmi://127.0.0.1/CalculadoraService");
            System.out.println("Adição: " + c.add(10, 15));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
