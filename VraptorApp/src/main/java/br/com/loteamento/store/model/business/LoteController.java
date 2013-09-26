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
import br.com.loteamento.store.model.dao.LoteDao;
import br.com.loteamento.store.model.dao.LoteamentoDao;
import br.com.loteamento.store.model.entity.Lote;

@Resource
@Path("/lote")
public class LoteController {

	private final LoteDao dao;
	
	@Autowired
	private LoteDao loteDao;
	@Autowired
	private LoteamentoDao loteamentoDao;
	
	private final Result result;
	private final Validator validator;
	
	public LoteController(LoteDao dao, Result result, Validator validator) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
	}
	
	@Get("")
	public void index(){
		result.include("comboLoteamento", loteamentoDao.loadAll());
		result.include("loteList", dao.loadAll());
	}
	
	@Get("/new")
	public Lote newLote() {
		result.include("comboLoteamento", loteamentoDao.loadAll());
		return new Lote();
	}
	
	@Post("")
	public void create(final Lote lote) {
		validator.checking(new Validations(){
			{
//				that(lote.getName() == null || lote.getName().length() >= 3 && lote.getName().length() <= 100,"erro", "product.nome.tamanho.invalido");
//				that(lote.getDescription() != null && lote.getDescription().length() > 0 ,"erro", "product.descricao.vazia");
			}
		});
		validator.onErrorUsePageOf(this).newLote();
		
		dao.create(lote);
		result.redirectTo(this).index();
	}
	
	@Put("")
	public void update(Lote lote) {
		validator.validate(lote);
		validator.onErrorUsePageOf(this).edit(lote);
		dao.update(lote);
		result.redirectTo(this).index();
	}
	
	@Get({"/{lote.id}/edit"})
	public Lote edit(Lote lote){
		result.include("comboLoteamento", loteamentoDao.loadAll());
		return dao.find(lote.getId());
	}
	
	@Delete("/{lote.id}")
	public void destroy(Lote lote){
		lote = dao.find(lote.getId());
		dao.destroy(lote);
		result.redirectTo(this).index();
	}
	
	@Get({"/{id}"})
	public Lote show(long id){
		return dao.find(id);		
	}
	
	@Get({"/{id}/xml"})
	public void toXML(long id){
		Lote lote = dao.find(id);
		result.use(Results.xml()).from(lote).serialize();
	}
	
	@Get({"/{id}/json"})
	public void toJson(long id){
		Lote lote = dao.find(id);
		result.use(Results.json()).from(lote).serialize();
	}
	
}