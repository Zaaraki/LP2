/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.*;

/**
 *
 * @author Amaro
 */
public class HelloServer {
    public static void main(String[] args) {
        try{
            Naming.rebind("rmi:HelloServer", new Hello("Hello World"));
        }catch(Exception e){
            
        }
    }
}
