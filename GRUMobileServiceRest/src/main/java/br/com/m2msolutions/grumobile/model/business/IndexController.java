package br.com.m2msolutions.grumobile.model.business;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
	private HttpServletResponse servletResponse;
	
	public IndexController(Result result, DaoService daoService, HttpServletResponse servletResponse) {
		this.result = result;
		this.daoService = daoService;
		this.servletResponse = servletResponse;
	}

	@Path("/")
	public void home() {
		
	}
	
	@Post
	@Path("/autenticacao")
	public void login(String usuario, String senha) {
		if (!daoService.autenticaUsuario(usuario, senha)){
			servletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			result.use(Results.json()).from("FAILURE", "retorno").serialize();
		}else{
			servletResponse.setStatus(HttpServletResponse.SC_OK);
			result.use(Results.json()).from("SUCCESS", "retorno").serialize();
		}
	}
	
	@Get
	@Path("/linhas")
	public void listaLinhas(){
		List<Linha> linhas = daoService.linhas();
		result.use(Results.json()).from(linhas, "linhas").serialize();
	}
	
	@Get
	@Path("/veiculos")
	public void veiculos(){
		List<Veiculo> veiculos = daoService.veiculos();
		result.use(Results.json()).from(veiculos, "veiculos").serialize();
	}
	
	@Get
	@Path("/tabelas/{idLinha}")
	public void tabelas(Integer idLinha){
		List<Tabela> tabelas = daoService.tabelas(idLinha);
		result.use(Results.json()).from(tabelas, "tabelas").serialize();
	}
	
	@Post
	@Path("/alocar")
	public void registraEscala(Integer idLinha, Integer idVeiculo, Integer idTabela) {
		try {
			daoService.registraEscala(idLinha, idVeiculo, idTabela);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
