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
		//创建选择器
		Selector selector = Selector.open();
		
		//打开监听信道
		ServerSocketChannel listenerChannel = ServerSocketChannel.open();
		
		//绑定本地端口
		listenerChannel.socket().bind(new InetSocketAddress(ListenPort));
		
		//设置为非阻塞
		listenerChannel.configureBlocking(false);
		
		//将选择器注册到监听信道，只有非阻塞信道才可以注册选择器，注册过程中指出该信道可以进行accept操作
		listenerChannel.register(selector, SelectionKey.OP_ACCEPT);
		TCPProtocol protocol = new TCPProtocolImpl(BufferSize);
		
		//返回等待IO
		while(true) {
			if(selector.select(TimeOut) == 0) {
				System.out.println("独自等待.");
				continue;
			}
			
			//迭代每一个准备好的IO操作的信道SelectionKey
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
				//移除处理过的键
				keyIter.remove();
			}
		}
	}

}
