package br.com.loteamento.store.model.business;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.loteamento.store.model.entity.User;

@Resource
public class IndexController {
	
	private final Result result;
	private final HttpServletRequest request;
	
	public IndexController(Result result, HttpServletRequest request) {
		this.result = result;
		this.request = request;
	}

	@Get("/")
	public void index() {
	}
	
	@Get("/menu")
	public void menu() {
		
	}
	
	@Get("/logoff")
	public void logoff() {
		request.getSession().removeAttribute("user");
		result.redirectTo(this).index();
	}
	
	@Post("/")
	public void login(User user){
		
		result.redirectTo(this).menu();
		
	}

}
