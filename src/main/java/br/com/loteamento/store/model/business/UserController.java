package br.com.loteamento.store.model.business;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.loteamento.store.model.dao.UserDao;
import br.com.loteamento.store.model.entity.User;

@Resource
public class UserController {

	private final Result result;
	private final UserDao dao;

	private final Validator validator;

	public UserController(Result result, UserDao dao, Validator validator) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
	}

	@Get("/users")
	public void index() {
		result.include("userList", dao.loadAll());
	}

	@Post("/users")
	public void create(User user) {
		validator.validate(user);
		validator.onErrorUsePageOf(this).newUser();
		dao.create(user);
		result.redirectTo(this).index();
	}

	@Get("/users/new")
	public User newUser() {
		return new User();
	}

	@Put("/users")
	public void update(User user) {
		validator.validate(user);
		validator.onErrorUsePageOf(this).edit(user);
		
		dao.update(user);
		result.redirectTo(this).index();
	}

	@Get("/users/{user.id}/edit")
	public User edit(User user) {

		return dao.find(user.getId());
	}

	@Get("/users/{user.id}")
	public User show(User user) {
		return dao.find(user.getId());
	}

	@Delete("/users/{user.id}")
	public void destroy(User user) {
		dao.destroy(dao.find(user.getId()));
		result.redirectTo(this).index();
	}
			
}