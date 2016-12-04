package javanet.concurrent_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	
	ServerSocket server = null;
	Socket socket = null;
	BufferedReader br = null;
	PrintWriter pw = null;
	
	public Server() {
		try {
			this.server = new ServerSocket(10086);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Listening....");
			try {
				this.socket = this.server.accept();
				ServerThread thread = new ServerThread(socket);
				thread.start();
				sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) {
		new Server().start();
	}
	
	class ServerThread extends Thread {
		
		Socket socket = null;
		
		public ServerThread(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			try {
				pw = new PrintWriter(socket.getOutputStream());
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String info = br.readLine();
				int count = 0;
				count++;
				System.out.println("服务端收到客户端信息：" + info + ";count=" + count);
				pw.write("服务器已收到信息{" + info + "}\n");
				pw.flush();
				System.out.println("已经返回客户端.");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}


