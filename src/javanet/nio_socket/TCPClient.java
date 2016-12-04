package javanet.nio_socket;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class TCPClient {
	//ͨ��ѡ����
	private Selector selector;
	
	//�������ͨ�ŵ��ŵ�
	private SocketChannel socketChannel;
	
	//������������ַ
	private String hostIp;
	
	//�����������Ķ˿�
	private int hostListenningPort;
	
	public TCPClient(String hostIp, int hostListenningPort) throws IOException {
		this.hostIp = hostIp;
		this.hostListenningPort = hostListenningPort;
		
		initialize();
	}
	
	private void initialize() throws IOException {
		//�򿪼���ͨ����������Ϊ������
		socketChannel = SocketChannel.open(new InetSocketAddress(hostIp, hostListenningPort));
		socketChannel.configureBlocking(false);
		
		//�򿪲�ע��ѡ�������ŵ�
		selector = Selector.open();
		socketChannel.register(selector, SelectionKey.OP_READ);
		
		//����һ���ͻ��˶�ȡ�߳�
		new TCPClientReadThread(selector);
	}
	
	public void sendMesssage(String message) throws Exception {
		ByteBuffer buffer = ByteBuffer.wrap(message.getBytes("utf-16"));
		socketChannel.write(buffer);
	}
	
	public static void main(String[] args) throws Exception {
		TCPClient client = new TCPClient("localhost", 10086);
		
		client.sendMesssage("���!Nio!�������ƿ���,�λش�����Ӫ");
	}

}
