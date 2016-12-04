package javanet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	
	public static void main(String[] args) throws IOException {
		//�����
		//1�������������˵�socket���Զ˿ڽ��м���
		DatagramSocket socket =new DatagramSocket(10010); 
		//2���������ݰ������ڽ��տͻ��˵�����
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		//3�����տͻ��˵�����
		socket.receive(packet);
		//4����ȡ����
		String info = new String(data, 0, data.length);
		System.out.println("�������յ��ͻ��˵����ݣ�" + info);
		
		//��ͻ�����Ӧ����
		//1������ͻ��˵ĵ�ַ���˿ڡ�����
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] bytes = "welcome".getBytes();
		//2���������ݰ������ڷ���
		DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, address, port);
		//3����Ӧ�ͻ���
		socket.send(datagramPacket);
		//4���ر���Դ
		socket.close();
	}

}
