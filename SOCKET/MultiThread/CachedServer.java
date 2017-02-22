import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class CachedServer{
	public static void main(String [] args) throws IOException{
		Executor exec = Executors.newCachedThreadPool();
		ServerSocket s = new ServerSocket(4444);
		while(true){
			Socket ns = s.accept();
			exec.execute(new ProtocolServer(ns));

		}
		//s.close();
	}
}