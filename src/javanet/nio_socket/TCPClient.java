package javanet.nio_socket;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class TCPClient {
	//通道选择器
	private Selector selector;
	
	//与服务器通信的信道
	private SocketChannel socketChannel;
	
	//服务器主机地址
	private String hostIp;
	
	//服务器监听的端口
	private int hostListenningPort;
	
	public TCPClient(String hostIp, int hostListenningPort) throws IOException {
		this.hostIp = hostIp;
		this.hostListenningPort = hostListenningPort;
		
		initialize();
	}
	
	private void initialize() throws IOException {
		//打开监听通道，并设置为非阻塞
		socketChannel = SocketChannel.open(new InetSocketAddress(hostIp, hostListenningPort));
		socketChannel.configureBlocking(false);
		
		//打开并注册选择器到信道
		selector = Selector.open();
		socketChannel.register(selector, SelectionKey.OP_READ);
		
		//启动一个客户端读取线程
		new TCPClientReadThread(selector);
	}
	
	public void sendMesssage(String message) throws Exception {
		ByteBuffer buffer = ByteBuffer.wrap(message.getBytes("utf-16"));
		socketChannel.write(buffer);
	}
	
	public static void main(String[] args) throws Exception {
		TCPClient client = new TCPClient("localhost", 10086);
		
		client.sendMesssage("你好!Nio!醉里挑灯看剑,梦回吹角连营");
	}

}
