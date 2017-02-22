
import java.net.*;
import java.io.*;

public class ThreadProtocol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        ServerSocket s = new ServerSocket(4444);
        while(true){
            Socket ns = s.accept();
            new Thread(new ProtocolServer(ns)).start();
        }
        
    }
    
}
