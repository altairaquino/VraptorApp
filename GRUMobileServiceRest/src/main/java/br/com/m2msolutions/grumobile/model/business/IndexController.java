package br.com.m2msolutions.grumobile.model.business;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.m2msolutions.grumobile.model.bean.Linha;
import br.com.m2msolutions.grumobile.model.bean.Tabela;
import br.com.m2msolutions.grumobile.model.bean.Veiculo;
import br.com.m2msolutions.grumobile.model.dao.DaoService;

@Resource
public class IndexController {
	
	private final Result result;
	private final DaoService daoService;
	
	public IndexController(Result result, DaoService daoService) {
		this.result = result;
		this.daoService = daoService;
	}

	@Path("/")
	public void home() {
		
	}
	
	@Post
	@Path("/login")
	public void login(String usuario, String senha) {
		
	}
	
	@Get
	@Path("/linhas")
	public void listaLinhas(){
		List<Linha> linhas = daoService.linhas();
		result.use(Results.json()).from(linhas, "linhas").serialize();
	}
	
	@Get
	@Path("/veiculos/{empresa}")
	public void veiculos(Integer empresa){
		List<Veiculo> veiculos = daoService.veiculos(empresa);
		result.use(Results.json()).from(veiculos, "veiculos").serialize();
	}
	
	@Get
	@Path("/tabelas/{linha}")
	public void tabelas(Integer linha){
		List<Tabela> tabelas = daoService.tabelas(linha);
		result.use(Results.json()).from(tabelas, "tabelas").serialize();
	}
	
	@Post
	@Path("/registraEscala")
	public void registraEscala(Integer veiculo, Integer linha, Integer tabela) {	
		
	}

}
