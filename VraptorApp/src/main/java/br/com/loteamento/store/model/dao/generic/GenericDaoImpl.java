package br.com.loteamento.store.model.dao.generic;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
                Session session = getSession();
                session.setFlushMode(FlushMode.MANUAL);
                Criteria criteria = (Criteria) session.createCriteria(classePersistente);
                criteria.add(Restrictions.eq("id", id));
                
                return (T) criteria.uniqueResult();
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
        public List<T> findAll(){
        	Criteria criteria = (Criteria) getSession().createCriteria(classePersistente);
        	criteria.addOrder(Order.asc("id"));

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
        
}