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
		//1�������ͻ���socket��ָ����������ַ�Ͷ˿�
		java.net.Socket socket = new java.net.Socket("localhost", 10086);
		//2����ȡ���������������������
		OutputStream outputStream = socket.getOutputStream();//�ֽ������
		PrintWriter pw = new PrintWriter(outputStream);//�������װ�ɴ�ӡ��
		pw.write("user:jack;pw:admin");
		pw.flush();
		socket.shutdownOutput();
		//��ȡ������������ȡ�������˵���Ӧ��Ϣ
		InputStream inputStream = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		String info = null;
		while((info = br.readLine())!=null) {
			System.out.println("�ͻ����յ���������ݣ�" + info);
		}
		
		//�ر���Դ
		br.close();
		inputStream.close();
		pw.close();
		outputStream.close();
		socket.close();
		System.out.println("closed");
	}
	
}
