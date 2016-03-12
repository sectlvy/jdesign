package com.sect.ejb.client;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sect.ejb.server.inf.HelloRemoteBean;

public class LKLClient {
	public static void main(String[] args){
		try {
			Properties properties = new Properties();
			properties.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
			properties.setProperty("java.naming.provider.url", "jnp://localhost");
			InitialContext ict = new InitialContext(properties);
			HelloRemoteBean helloRemoteBean = (HelloRemoteBean)ict.lookup("HelloLocalBean/remote");
			helloRemoteBean.sayHello("123");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
