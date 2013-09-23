package br.com.loteamento.store.model.dao.impl;

import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.loteamento.store.model.dao.ContratoDao;
import br.com.loteamento.store.model.dao.generic.GenericDaoImpl;
import br.com.loteamento.store.model.entity.Contrato;

@Component
public class ContratoDaoImpl extends GenericDaoImpl<Contrato> implements ContratoDao{

	public ContratoDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
}
