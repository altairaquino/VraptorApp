package br.com.loteamento.store.model.dao.impl;

import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.loteamento.store.model.dao.FormaPagamentoDao;
import br.com.loteamento.store.model.dao.generic.GenericDaoImpl;
import br.com.loteamento.store.model.entity.FormaPagamento;

@Component
public class FormaPagamentoDaoImpl extends GenericDaoImpl<FormaPagamento> implements FormaPagamentoDao{

	public FormaPagamentoDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
}