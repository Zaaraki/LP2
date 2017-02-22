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
public class Protocol {

    enum OPERATOR {
        ADD, SUB, MULT, DIV, QUIT, RESULT
    };

    public Protocol() {

    }

    public String Operation(Socket s, String command) throws IOException{

        String[] var = command.split(" ");

        String com = var[0];
        int v1 = Integer.parseInt(var[1]);
        int v2 = Integer.parseInt(var[2]);
        int result = 0;

        OPERATOR op = OPERATOR.valueOf(com.toUpperCase());

        switch (op) {
            case ADD:
                result = v1 + v2;
                break;

            case SUB:
                result = v1 - v2;
                break;

            case MULT:
                result = v1 * v2;
                break;

            case DIV:
                result = v1 / v2;
                break;
                
            case QUIT:
                s.close();
                break;
                
        }

        return Integer.toString(result);
    }

}
