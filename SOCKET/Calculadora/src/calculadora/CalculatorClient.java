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
public class CalculatorClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String op;

        try {

            Socket s = new Socket("localhost", 4444);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                op = stdIn.readLine();
                out.writeUTF(op);
                System.out.println(in.readUTF());
                if (op.equals("QUIT")) {
                    break;
                }
            }

            in.close();
            out.close();
            stdIn.close();
            s.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
