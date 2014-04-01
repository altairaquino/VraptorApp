package br.com.loteamento.store.model.business;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
@Path("/relatorio")
public class RelatorioController {
	
	private final Result result;
	
	public RelatorioController(Result result) {
		this.result = result;
	}

	@Get("")
	public void index() {
		
	}
	
	@Get("/vendas")
	public void vendas() {
		
	}

	@Post("/vendas")
	public void relatorioVendas() {
		result.redirectTo(this).vendas();
	}

}