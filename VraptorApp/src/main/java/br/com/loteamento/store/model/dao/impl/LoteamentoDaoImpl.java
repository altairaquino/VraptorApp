package br.com.loteamento.store.model.dao.impl;

import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.loteamento.store.model.dao.LoteamentoDao;
import br.com.loteamento.store.model.dao.generic.GenericDaoImpl;
import br.com.loteamento.store.model.entity.Loteamento;

@Component
public class LoteamentoDaoImpl extends GenericDaoImpl<Loteamento> implements LoteamentoDao{

	public LoteamentoDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
}