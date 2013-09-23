package br.com.loteamento.store.model.dao.impl;

import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.loteamento.store.model.dao.LoteDao;
import br.com.loteamento.store.model.dao.generic.GenericDaoImpl;
import br.com.loteamento.store.model.entity.Lote;

@Component
public class LoteDaoImpl extends GenericDaoImpl<Lote> implements LoteDao{

	public LoteDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
}