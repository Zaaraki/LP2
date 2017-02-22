import java.io.*;
import java.util.*;
import java.net.*;

public class ProtocolServer{
	public static void main(String[] args) throws IOException {
		String fromClient;
		Protocol protocol = new Protocol();

		ServerSocket s = new ServerSocket(4444);
		while(true){
			Socket ns = s.accept();
			DataInputStream in = new DataInputStream(ns.getInputStream());
			DataOutputStream out = new DataOutputStream(ns.getOutputStream());
			while(true){
				fromClient = in.readUTF();
				out.writeUTF(protocol.processLine(fromClient));
				if(fromClient.equals("Bye")) break;
			}
		in.close();
		out.close();
		ns.close();
		}
//s.close();

	}
}