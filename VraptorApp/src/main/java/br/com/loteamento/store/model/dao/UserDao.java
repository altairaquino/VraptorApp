package br.com.loteamento.store.model.dao;

import br.com.loteamento.store.model.dao.generic.GenericDao;
import br.com.loteamento.store.model.entity.User;

public interface UserDao extends GenericDao<User>{

        User findByLogin(String login);

}