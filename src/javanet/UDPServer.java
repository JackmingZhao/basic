package javanet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	
	public static void main(String[] args) throws IOException {
		//服务端
		//1、创建服务器端的socket，对端口进行监听
		DatagramSocket socket =new DatagramSocket(10010); 
		//2、创建数据包，用于接收客户端的数据
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		//3、接收客户端的数据
		socket.receive(packet);
		//4、读取数据
		String info = new String(data, 0, data.length);
		System.out.println("服务器收到客户端的数据：" + info);
		
		//向客户端响应数据
		//1、定义客户端的地址、端口、数据
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] bytes = "welcome".getBytes();
		//2、创建数据包，用于发送
		DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, address, port);
		//3、响应客户端
		socket.send(datagramPacket);
		//4、关闭资源
		socket.close();
	}

}
