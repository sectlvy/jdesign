package com.sect.ejb.server.inf.jdbc;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.sect.ejb.server.bean.Product;
import com.sect.ejb.server.impl.jdbc.ProductServiceImpl;
@Remote(ProductServiceImpl.class)
public interface IProductService {
	void delete(Product product);
	void update(Product product);
	void save(Product product);
	Product query(String id);
	List<Product> querys(String sql);
}
