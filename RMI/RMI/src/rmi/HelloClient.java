/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Naming;

/**
 *
 * @author Amaro
 */
public class HelloClient {
    public static void main(String[] args) {
        HelloInterface hello;
        String name = "rmi://127.0.0.1/HelloServer";
        String text;
        try{
            hello = (HelloInterface)Naming.lookup(name);
            text = hello.sayHello();
            System.out.println(text);
                    
        }catch(Exception e){
            System.out.println("HelloClient exception: " + e);
        }
    }
}
