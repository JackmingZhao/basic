package javanet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.UnknownHostException;

public class Socket {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//1、创建客户端socket，指定服务器地址和端口
		java.net.Socket socket = new java.net.Socket("localhost", 10086);
		//2、获取输出流，向服务端输送数据
		OutputStream outputStream = socket.getOutputStream();//字节输出流
		PrintWriter pw = new PrintWriter(outputStream);//输出流包装成打印流
		pw.write("user:jack;pw:admin");
		pw.flush();
		socket.shutdownOutput();
		//截取输入流，并读取服务器端的响应信息
		InputStream inputStream = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		String info = null;
		while((info = br.readLine())!=null) {
			System.out.println("客户端收到服务端数据：" + info);
		}
		
		//关闭资源
		br.close();
		inputStream.close();
		pw.close();
		outputStream.close();
		socket.close();
		System.out.println("closed");
	}
	
}
