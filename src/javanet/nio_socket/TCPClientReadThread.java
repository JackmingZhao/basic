package javanet.nio_socket;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class TCPClientReadThread implements Runnable {
	private Selector selector;
	
	//构造函数中获得一个信道选择器
	public TCPClientReadThread(Selector _selector) {
		this.selector = _selector;
		
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		try {
			while (selector.select() > 0) {//有准备好的信道
				//遍历每个有可用IO操作Channel对应的SelectionKey
				//向选择器中注册信道的时候都会创建一个选择键
				for(SelectionKey sk : selector.selectedKeys()) {
					//如果该key对应的channel中有可读数据
					if(sk.isReadable()) {
						//使用nio读取流
						SocketChannel sc = (SocketChannel) sk.channel();
						ByteBuffer buffer = ByteBuffer.allocate(1024);
						sc.read(buffer);
						buffer.flip();
						
						//将字节进行转换
						String receiveString = Charset.forName("utf-16").newDecoder().decode(buffer).toString();
						
						//打印结构
						System.out.println("接收到来至服务器"+sc.socket().getRemoteSocketAddress()+"的信息:"+receiveString);
						
						//为下一次读取做准备
						sk.interestOps(SelectionKey.OP_READ);
					}
					
					//删除正在处理的key
					selector.selectedKeys().remove(sk);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
