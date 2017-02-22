
import java.net.*;
import java.io.*;

public class ProtocolServer implements Runnable{
    
    Socket s;
    
    public ProtocolServer (Socket ns){
        s = ns;
    }
  
    public void run(){
        Protocol protocol = new Protocol();
        try{
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            while(true){
                String fromClient = in.readUTF();
                out.writeUTF(protocol.processLine(fromClient));
                if(fromClient.equals("Bye")) break;
            }
            in.close();
            out.close();
            s.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
