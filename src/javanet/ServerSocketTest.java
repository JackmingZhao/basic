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
		//1����������ˣ����󶨶˿�
		ServerSocket server = new ServerSocket(10086);
		//2������accept���������м������ȴ��ͻ�������
		Socket client = server.accept();
		//3����ȡ����������ȡ�ͻ�����Ϣ
		InputStream inputStream = client.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		String info = null;
		while((info=br.readLine())!=null) {
			System.out.println("������յ��ͻ������ݣ�" + info);
		}
		client.shutdownInput();//�ر�������
		//4����ȡ���������Ӧ�ͻ��˵�����
		OutputStream outputStream = client.getOutputStream();
		PrintWriter pw = new PrintWriter(outputStream);
		pw.write("return-data");
		
		//�ر�����
		pw.flush();
		pw.close();
		outputStream.close();
		br.close();
		inputStream.close();
		client.close();
		server.close();
	}
	
}
