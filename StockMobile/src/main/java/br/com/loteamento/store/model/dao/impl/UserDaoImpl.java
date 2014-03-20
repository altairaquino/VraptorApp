package br.com.loteamento.store.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.loteamento.store.model.dao.UserDao;
import br.com.loteamento.store.model.dao.generic.GenericDaoImpl;
import br.com.loteamento.store.model.entity.User;

@Component
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

        public UserDaoImpl(SessionFactory sessionFactory) {
                super(sessionFactory);
        }
        
        public User findByLogin(String login) {
                Session session = getSession();
                session.setFlushMode(FlushMode.MANUAL);
                Criteria criteria = (Criteria) session.createCriteria(User.class);
                criteria.add(Restrictions.eq("login", login));
                
                return (User) criteria.uniqueResult();
        }
        
}	