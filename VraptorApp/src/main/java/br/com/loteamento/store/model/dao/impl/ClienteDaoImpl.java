package br.com.loteamento.store.model.dao.impl;

import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.loteamento.store.model.dao.ClienteDao;
import br.com.loteamento.store.model.dao.generic.GenericDaoImpl;
import br.com.loteamento.store.model.entity.Cliente;

@Component
public class ClienteDaoImpl extends GenericDaoImpl<Cliente> implements ClienteDao{

	public ClienteDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
}
