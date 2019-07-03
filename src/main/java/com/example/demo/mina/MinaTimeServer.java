package com.example.demo.mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * @author vipkid
 * @date 2019/06/25
 **/
public class MinaTimeServer {

	public static void main(String[] args) throws IOException {

		//创建服务端
		NioSocketAcceptor acceptor = new NioSocketAcceptor();

		// 添加过滤器, 客户端链接以后所有接受的消息都会先经过过滤器
		acceptor.getFilterChain().addLast("logger",new LoggingFilter());
		acceptor.getFilterChain().addLast("protocol",new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("utf-8"))));

		// 设置请求处理
		acceptor.setHandler(new TimeServerHandler());

		// 设置服务器每次读取的缓冲区大小
		acceptor.getSessionConfig().setReadBufferSize(2048);
		// 设置空闲时间
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);
		acceptor.bind( new InetSocketAddress(8989) );
	}
}
