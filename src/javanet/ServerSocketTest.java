package javanet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {

	public static void main(String[] args) throws IOException {
		//1、创建服务端，并绑定端口
		ServerSocket server = new ServerSocket(10086);
		//2、调用accept方法，进行监听，等待客户端连接
		Socket client = server.accept();
		//3、获取输入流，读取客户端信息
		InputStream inputStream = client.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		String info = null;
		while((info=br.readLine())!=null) {
			System.out.println("服务端收到客户端数据：" + info);
		}
		client.shutdownInput();//关闭输入流
		//4、获取输出流，响应客户端的请求
		OutputStream outputStream = client.getOutputStream();
		PrintWriter pw = new PrintWriter(outputStream);
		pw.write("return-data");
		
		//关闭请求
		pw.flush();
		pw.close();
		outputStream.close();
		br.close();
		inputStream.close();
		client.close();
		server.close();
	}
	
}
