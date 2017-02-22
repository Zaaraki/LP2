import java.net.*;
import java.io.*;

public class ProtocolServer{

	public static void main(String[] args) throws IOException{
		Protocol protocol = new Protocol();

		ServerSocket s = new ServerSocket(4444);
		Socket ns = s.accept();
		DataInputStream in = new DataInputStream(ns.getInputStream());
		DataOutputStream out = new DataOutputStream(ns.getOutputStream());
		while(true){
			String fromClient = in.readUTF();
			out.writeUTF(protocol.processline(fromClient));
			if(fromClient.equals("Bye")) break;
		}
		in.close();
		out.close();
		ns.close();
	
		s.close();
	}
}