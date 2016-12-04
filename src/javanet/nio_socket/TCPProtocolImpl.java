package javanet.nio_socket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Date;

public class TCPProtocolImpl implements TCPProtocol {
	private int bufferSize;
	
	public TCPProtocolImpl(int bufferSize) {
		this.bufferSize = bufferSize;
	}

	@Override
	public void handleAccept(SelectionKey key) throws IOException {
		SocketChannel client = ((ServerSocketChannel)key.channel()).accept();
		client.configureBlocking(false);
		client.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
	}

	@Override
	public void handleRead(SelectionKey key) throws IOException {
		//����ͻ���ͨ�ŵ��ŵ��ж�ȡ����
		SocketChannel clientChannel = (SocketChannel) key.channel();
		ByteBuffer buffer = (ByteBuffer) key.attachment();
		buffer.clear();
		int bytesRead = clientChannel.read(buffer);
		if(bytesRead == -1) {
			clientChannel.close();
		} else {
			buffer.flip();
			String receiveString = Charset.forName("utf-16").newDecoder().decode(buffer).toString();
			System.out.println("���յ�����" + clientChannel.socket().getRemoteSocketAddress() + "����Ϣ��" + receiveString);
			
			//���ŵ���д������
			String sendString = "���,�ͻ���.@" + new Date().toString() + ",�Ѿ��յ������Ϣ"+receiveString;
			buffer = ByteBuffer.wrap(sendString.getBytes("utf-16"));
			clientChannel.write(buffer);
			key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
		}
	}

	@Override
	public void handleWrite(SelectionKey key) throws IOException {
		// TODO Auto-generated method stub

	}

}
