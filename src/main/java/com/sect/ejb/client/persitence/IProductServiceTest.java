package com.sect.ejb.client.persitence;

import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sect.ejb.server.bean.Product;
import com.sect.ejb.server.inf.jdbc.IProductService;

public class IProductServiceTest {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		Properties properties = new Properties();
		properties.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		properties.setProperty("java.naming.provider.url", "jnp://localhost");
		InitialContext ict = new InitialContext(properties);
		
		IProductService productService = (IProductService)ict.lookup("ProductServiceImpl/remote");
		List<Product> products = productService.querys("select o  from Product o");
		
		products.get(0);
		Product product = new Product();
		product.setInfo("lkl ejb product test 1");
		product.setName("houhou123");
		productService.save(product);
	}

}
