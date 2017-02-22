/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequencial;

import java.util.Scanner;

/**
 *
 * @author Amaro
 */
public class Sequencial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        int id = num.nextInt();

        Printer p = new Printer(id);

        for (int i = 0; i < id; i++) {
            (new Print(i, p)).start();
        }
    }

}
