package javanet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	
	public static void main(String[] args) throws IOException {
		//客户端
		//1、定义服务器的地址、端口号、数据包
		InetAddress address = InetAddress.getByName("localhost");
		int port = 10010;
		byte[] data = "user:admin;pw:123".getBytes();
		//2、创建数据包，包含发送的数据信息
		DatagramPacket datagramPacket = new DatagramPacket(data, data.length, address, port);
		//3、创建DatagramSocket
		DatagramSocket socket = new DatagramSocket();
		//4、向服务器发送数据
		socket.send(datagramPacket);
		
		//接收服务器端的响应数据
		//1、创建数据包，用于接收服务器响应数据
		byte[] receive = new byte[1024];
		DatagramPacket datagramPacket2 = new DatagramPacket(receive, receive.length);
		//2、接收服务器响应数据
		socket.receive(datagramPacket2);
		String receinfo = new String(receive, 0, receive.length);
		System.out.println("客户端收到服务端反馈：" + receinfo);
		//3、关闭资源
		socket.close();
	}

}
