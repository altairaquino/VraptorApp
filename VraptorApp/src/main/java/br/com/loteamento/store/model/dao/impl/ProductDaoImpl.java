package br.com.loteamento.store.model.dao.impl;

import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.loteamento.store.model.dao.ProductDao;
import br.com.loteamento.store.model.dao.generic.GenericDaoImpl;
import br.com.loteamento.store.model.entity.Product;

@Component
public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao{

	public ProductDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
}
