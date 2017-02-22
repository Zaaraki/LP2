/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;
import java.net.*;
import java.io.*;

/**
 *
 * @author Amaro
 */
public class Calculator {
    public static void main(String[] args) {
        try{
            
        ServerSocket s = new ServerSocket(4444);
            while (true) {
                Socket ns = s.accept();
                new Thread(new CalculatorServer(ns)).start();
            }
        
        }catch(IOException e){
        e.printStackTrace();
    }
    }
}
