package br.com.loteamento.store.model.business;

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
import br.com.loteamento.store.model.entity.Cliente;

@Resource
@Path("/cliente")
public class ClienteController {

	private final ClienteDao dao;
	private final Result result;
	private final Validator validator;
	
	public ClienteController(ClienteDao dao, Result result, Validator validator) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
	}
	
	@Get("")
	public void index(){
		result.include("clienteList", dao.loadAll());
	}
	
	@Get("/new")
	public Cliente newCliente() {
		return new Cliente();
	}
	
	@Post("")
	public void create(final Cliente cliente) {
		validator.checking(new Validations(){
			{
//				that(cliente.getName() == null || cliente.getName().length() >= 3 && cliente.getName().length() <= 100,"erro", "product.nome.tamanho.invalido");
//				that(cliente.getDescription() != null && cliente.getDescription().length() > 0 ,"erro", "product.descricao.vazia");
			}
		});
		validator.onErrorUsePageOf(this).newCliente();
		
		dao.create(cliente);
		result.redirectTo(this).index();
	}
	
	@Put("")
	public void update(Cliente cliente) {
		validator.validate(cliente);
		validator.onErrorUsePageOf(this).edit(cliente);		
		dao.update(cliente);
		result.redirectTo(this).index();
	}
	
	@Get({"/{cliente.id}/edit"})
	public Cliente edit(Cliente cliente){
		return dao.find(cliente.getId());
	}
	
	@Delete("/{cliente.id}")
	public void destroy(Cliente cliente){
		cliente = dao.find(cliente.getId());
		dao.destroy(cliente);
		result.redirectTo(this).index();
	}
	
	@Get({"/{id}"})
	public Cliente show(long id){
		return dao.find(id);		
	}
	
	@Get({"/{id}/xml"})
	public void toXML(long id){
		Cliente cliente = dao.find(id);
		result.use(Results.xml()).from(cliente).serialize();
	}
	
	@Get({"/{id}/json"})
	public void toJson(long id){
		Cliente cliente = dao.find(id);
		result.use(Results.json()).from(cliente).serialize();
	}
	
}