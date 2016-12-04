package javanet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	
	public static void main(String[] args) throws IOException {
		//�ͻ���
		//1������������ĵ�ַ���˿ںš����ݰ�
		InetAddress address = InetAddress.getByName("localhost");
		int port = 10010;
		byte[] data = "user:admin;pw:123".getBytes();
		//2���������ݰ����������͵�������Ϣ
		DatagramPacket datagramPacket = new DatagramPacket(data, data.length, address, port);
		//3������DatagramSocket
		DatagramSocket socket = new DatagramSocket();
		//4�����������������
		socket.send(datagramPacket);
		
		//���շ������˵���Ӧ����
		//1���������ݰ������ڽ��շ�������Ӧ����
		byte[] receive = new byte[1024];
		DatagramPacket datagramPacket2 = new DatagramPacket(receive, receive.length);
		//2�����շ�������Ӧ����
		socket.receive(datagramPacket2);
		String receinfo = new String(receive, 0, receive.length);
		System.out.println("�ͻ����յ�����˷�����" + receinfo);
		//3���ر���Դ
		socket.close();
	}

}
