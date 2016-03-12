package com.sect.ejb.client.messagesender;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Properties;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.sect.ejb.server.bean.Product;


public class StateChangeDispatcher {
	
	public static void main(String[] args) throws NamingException, JMSException, UnknownHostException{
		Logger loger = Logger.getLogger(StateChangeDispatcher.class);
		Properties properties = new Properties();
		loger.error("123123123");
		properties.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		properties.setProperty("java.naming.provider.url", "jnp://localhost");
		InitialContext ict = new InitialContext(properties);
		
		QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory)ict.lookup("ConnectionFactory");
		QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
		QueueSession qs = queueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		
		//Destination destination =	(Destination)ict.lookup("/queue/lklPTPDistributedQueue");
		Destination destination =	(Destination)ict.lookup("queue/lklPTPDistributedQueue");
		MessageProducer messageProducer = qs.createProducer(destination);
		Product product = new Product();
		product.setInfo("create by time "+(new Date())+"/r/n ip:"+InetAddress.getLocalHost().getHostAddress());
		product.setName((new Date()).getDay()+"Pro");
		messageProducer.send(qs.createObjectMessage(product));
		qs.close();
		queueConnection.close();
	}
	
}
