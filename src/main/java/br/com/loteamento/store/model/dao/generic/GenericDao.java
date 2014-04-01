package br.com.loteamento.store.model.dao.generic;

import java.util.List;

import org.hibernate.criterion.Order;

public interface GenericDao<T> {

        public T find(Long id);
        public T create(T objeto);
        public T update(T objeto);
        public void destroy(T objeto);
        public List<T> loadAll();
		public List<T> loadAll(Order order);
        
}