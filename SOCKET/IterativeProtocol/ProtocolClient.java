import java.io.*;
import java.util.*;
import java.net.*;

public class ProtocolClient{
	public static void main(String[] args) throws IOException {
		String fromUser;

		Socket s = new Socket("localhost", 4444);
		DataInputStream in = new DataInputStream(s.getInputStream());
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			fromUser = stdIn.readLine();
			out.writeUTF(fromUser);
			System.out.println(in.readUTF());
			if(fromUser.equals("Bye")) break;
		}
		in.close();
		out.close();
		stdIn.close();
		s.close();
	}
}