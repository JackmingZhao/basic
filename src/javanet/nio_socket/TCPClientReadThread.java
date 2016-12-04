package javanet.nio_socket;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class TCPClientReadThread implements Runnable {
	private Selector selector;
	
	//���캯���л��һ���ŵ�ѡ����
	public TCPClientReadThread(Selector _selector) {
		this.selector = _selector;
		
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		try {
			while (selector.select() > 0) {//��׼���õ��ŵ�
				//����ÿ���п���IO����Channel��Ӧ��SelectionKey
				//��ѡ������ע���ŵ���ʱ�򶼻ᴴ��һ��ѡ���
				for(SelectionKey sk : selector.selectedKeys()) {
					//�����key��Ӧ��channel���пɶ�����
					if(sk.isReadable()) {
						//ʹ��nio��ȡ��
						SocketChannel sc = (SocketChannel) sk.channel();
						ByteBuffer buffer = ByteBuffer.allocate(1024);
						sc.read(buffer);
						buffer.flip();
						
						//���ֽڽ���ת��
						String receiveString = Charset.forName("utf-16").newDecoder().decode(buffer).toString();
						
						//��ӡ�ṹ
						System.out.println("���յ�����������"+sc.socket().getRemoteSocketAddress()+"����Ϣ:"+receiveString);
						
						//Ϊ��һ�ζ�ȡ��׼��
						sk.interestOps(SelectionKey.OP_READ);
					}
					
					//ɾ�����ڴ����key
					selector.selectedKeys().remove(sk);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
