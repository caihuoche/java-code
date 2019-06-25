package com.example.demo.mina;


import java.util.Date;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.FilterEvent;

/**
 * @author vipkid
 * @date 2019/06/25
 **/
public class TimeServerHandler extends IoHandlerAdapter {
	@Override
	public void sessionCreated(IoSession ioSession) throws Exception {

	}

	@Override
	public void sessionOpened(IoSession ioSession) throws Exception {

	}

	@Override
	public void sessionClosed(IoSession ioSession) throws Exception {

	}

	@Override
	public void sessionIdle(IoSession ioSession, IdleStatus idleStatus) throws Exception {
		System.out.println("hahaha");
		System.out.println("IDLE " + ioSession.getIdleCount(idleStatus));
	}

	@Override
	public void exceptionCaught(IoSession ioSession, Throwable throwable) throws Exception {

	}

	@Override
	public void messageReceived(IoSession ioSession, Object message) throws Exception {
		String str = message.toString();
		if (str.trim().equalsIgnoreCase("quit")) {
			ioSession.close();
			return;
		}

		Date date = new Date();
		ioSession.write(date.toString());
		System.out.println("Message written..." + message.toString());
	}

	@Override
	public void messageSent(IoSession ioSession, Object o) throws Exception {

	}

	@Override
	public void inputClosed(IoSession ioSession) throws Exception {

	}

	@Override
	public void event(IoSession ioSession, FilterEvent filterEvent) throws Exception {

	}
}
