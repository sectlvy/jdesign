package com.sect.ejb.server.jms.mdb;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.sql.DataSource;

import com.sect.ejb.server.bean.Product;
import com.sect.ejb.server.inf.jdbc.IProductService;
import com.sun.jersey.spi.inject.Inject;

@MessageDriven(
		name="PTPMdbBean",
		activationConfig={
				@ActivationConfigProperty(
						propertyName="destinationType",
						propertyValue="javax.jms.Queue"
				),
				@ActivationConfigProperty(
						propertyName="destination",
						propertyValue="queue/lklPTPDistributedQueue"
				)
		}
)
public class PTPMdbBean implements MessageListener {
	@Resource(mappedName="java:/MySqlDS")
	private DataSource dataSource;
	private Connection connection;
	@Resource
	private MessageDrivenContext messageDrivenContext;
	@Inject
	private IProductService productService;
	@PostConstruct
	public void init(){
		System.out.println("init");
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void onMessage(Message message) {
		ObjectMessage objectMessage = (ObjectMessage)message;
		try {
			productService.save((Product)objectMessage.getObject());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		System.out.println(message);
	}
	@PreDestroy
	public void predestory(){
		System.out.println("predestory");
	}
	
}
