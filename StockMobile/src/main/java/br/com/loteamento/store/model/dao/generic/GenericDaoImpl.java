package br.com.loteamento.store.model.dao.generic;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

public class GenericDaoImpl<T> implements GenericDao<T> {

	protected final SessionFactory sessionFactory;
	protected final Class<T> classePersistente;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		this.classePersistente = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	@SuppressWarnings("unchecked")
	public T find(Long id){
		return (T)getSession().load(classePersistente, id);
	}

	@Override
	public T create(T objeto) {
		Session session = getSession();
		session.persist(objeto);
		session.flush();
		return objeto;
	}

	@Override
	public T update(T objeto) {
		Session session = getSession();
		session.merge(objeto);
		session.flush();
		return objeto;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> loadAll(){
		Criteria criteria = (Criteria) getSession().createCriteria(classePersistente);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> loadAll(Order order){
		Criteria criteria = (Criteria) getSession().createCriteria(classePersistente);
		criteria.addOrder(order);
		return criteria.list();
	}

	@Override
	public void destroy(T objeto) {
		Session session = getSession();
		session.delete(objeto);
		session.flush();
	}

	protected Session getSession(){
		return sessionFactory.openSession();
	}
	
	protected Criteria createCriteria(){
		return getSession().createCriteria(classePersistente);
	}
	
	protected Query createQuery(String qr){
		return getSession().createQuery(qr);
	}

}