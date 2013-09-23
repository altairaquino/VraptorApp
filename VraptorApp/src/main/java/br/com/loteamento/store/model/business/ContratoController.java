package br.com.loteamento.store.model.business;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;
import br.com.loteamento.store.model.dao.ClienteDao;
import br.com.loteamento.store.model.dao.ContratoDao;
import br.com.loteamento.store.model.dao.FormaPagamentoDao;
import br.com.loteamento.store.model.dao.LoteDao;
import br.com.loteamento.store.model.entity.Contrato;

@Resource
@Path("/contrato")
public class ContratoController {

	private final ContratoDao dao;
	
	@Autowired
	private ClienteDao clienteDao;
	@Autowired
	private LoteDao loteDao;
	@Autowired
	private FormaPagamentoDao formaPagamentoDao;
	
	private final Result result;
	private final Validator validator;
	
	public ContratoController(ContratoDao dao, Result result, Validator validator) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
	}
	
	@Get("")
	public void index(){
		result.include("comboCliente", clienteDao.loadAll());
		result.include("comboLote", loteDao.loadAll());
		result.include("comboFormaPagamento", formaPagamentoDao.loadAll());
		result.include("contratoList", dao.loadAll());
	}
	
	@Get("/new")
	public Contrato newContrato() {
		return new Contrato();
	}
	
	@Post("")
	public void create(final Contrato contrato) {
		validator.checking(new Validations(){
			{
//				that(contrato.getName() == null || contrato.getName().length() >= 3 && contrato.getName().length() <= 100,"erro", "product.nome.tamanho.invalido");
//				that(contrato.getDescription() != null && contrato.getDescription().length() > 0 ,"erro", "product.descricao.vazia");
			}
		});
		validator.onErrorUsePageOf(this).newContrato();
		
		dao.create(contrato);
		result.redirectTo(this).index();
	}
	
	@Put("")
	public void update(Contrato contrato) {
		validator.validate(contrato);
		validator.onErrorUsePageOf(this).edit(contrato);		
		dao.update(contrato);
		result.redirectTo(this).index();
	}
	
	@Get({"/{contrato.id}/edit"})
	public Contrato edit(Contrato contrato){
		return dao.find(contrato.getId());
	}
	
	@Delete("/{contrato.id}")
	public void destroy(Contrato contrato){
		contrato = dao.find(contrato.getId());
		dao.destroy(contrato);
		result.redirectTo(this).index();
	}
	
	@Get({"/{id}"})
	public Contrato show(long id){
		return dao.find(id);		
	}
	
	@Get({"/{id}/xml"})
	public void toXML(long id){
		Contrato contrato = dao.find(id);
		result.use(Results.xml()).from(contrato).serialize();
	}
	
	@Get({"/{id}/json"})
	public void toJson(long id){
		Contrato contrato = dao.find(id);
		result.use(Results.json()).from(contrato).serialize();
	}
	
}