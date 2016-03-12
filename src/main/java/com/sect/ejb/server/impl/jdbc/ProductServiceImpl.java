package com.sect.ejb.server.impl.jdbc;

import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.sect.ejb.client.messagesender.StateChangeDispatcher;
import com.sect.ejb.server.bean.Product;
import com.sect.ejb.server.inf.jdbc.IProductService;
import com.sect.ejb.server.logger.ProductProcessLogger;
@Stateless
@Interceptors(ProductProcessLogger.class)
public class ProductServiceImpl implements IProductService {
	@PersistenceContext(unitName="jboosdb") EntityManager em;
	
	public ProductServiceImpl(){}
	@Override
	public void delete(Product product) {
		em.remove(em.getReference(Product.class, product.getId()));//托管状态
	}
	@Override
	public void update(Product product) {
		em.merge(product);//游离状态 无事务关联 
		//其他状态使用 save
		
	}
	@Override
	public void save(Product product) {
		em.persist(product);
	}

	@Override
	public Product query(String id) {
		// TODO Auto-generated method stub
		return em.find(Product.class, id);
	}

	@Override
	public List<Product> querys(String sql) {
		return em.createQuery(sql).getResultList();
	}


}
