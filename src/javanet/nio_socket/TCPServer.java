package javanet.nio_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class TCPServer {
	private static final int BufferSize = 1024;
	
	private static final int TimeOut = 3000;
	
	private static final int ListenPort = 10086;
	
	public static void main(String[] args) throws IOException {
		//����ѡ����
		Selector selector = Selector.open();
		
		//�򿪼����ŵ�
		ServerSocketChannel listenerChannel = ServerSocketChannel.open();
		
		//�󶨱��ض˿�
		listenerChannel.socket().bind(new InetSocketAddress(ListenPort));
		
		//����Ϊ������
		listenerChannel.configureBlocking(false);
		
		//��ѡ����ע�ᵽ�����ŵ���ֻ�з������ŵ��ſ���ע��ѡ������ע�������ָ�����ŵ����Խ���accept����
		listenerChannel.register(selector, SelectionKey.OP_ACCEPT);
		TCPProtocol protocol = new TCPProtocolImpl(BufferSize);
		
		//���صȴ�IO
		while(true) {
			if(selector.select(TimeOut) == 0) {
				System.out.println("���Եȴ�.");
				continue;
			}
			
			//����ÿһ��׼���õ�IO�������ŵ�SelectionKey
			Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
			while(keyIter.hasNext()) {
				SelectionKey key = keyIter.next();
				try {
					if(key.isAcceptable()) {
						protocol.handleAccept(key);
					}
					
					if(key.isReadable()) {
						protocol.handleRead(key);
					}
					if(key.isValid() && key.isWritable()) {
						protocol.handleWrite(key);
					}
				} catch (Exception e) {
					keyIter.remove();
					continue;
				}
				//�Ƴ�������ļ�
				keyIter.remove();
			}
		}
	}

}
