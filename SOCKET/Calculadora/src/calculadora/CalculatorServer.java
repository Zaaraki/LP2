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
public class CalculatorServer implements Runnable{
    
    Socket s;
    
    
    public CalculatorServer(Socket ns){
        s=ns;
    }
    
    public void run(){
        Protocol protocol = new Protocol();
        String fromClient = "";
        
        try{
            
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            if(fromClient!="QUIT") {
                fromClient = in.readUTF();
                out.writeUTF(protocol.Operation(s, fromClient));                
                //if(fromClient.equals("QUIT")) s.close();
            }
            else if (out.equals("QUIT")){
            
                in.close();
                out.close();
                s.close();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
