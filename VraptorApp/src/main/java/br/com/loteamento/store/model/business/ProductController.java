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
import br.com.loteamento.store.model.dao.ProductDao;
import br.com.loteamento.store.model.entity.Product;

@Resource
@Path("/products")
public class ProductController {

	private final ProductDao dao;
	private final Result result;
	private final Validator validator;
	
	public ProductController(ProductDao dao, Result result, Validator validator) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
	}	
	
	@Get("")
	public void index(){
		result.include("productList", dao.loadAll());
	}
	
	@Get("/new")
	public Product newProduct() {
		return new Product();
	}
	
	@Post("")
	public void create(final Product product) {
		validator.checking(new Validations(){
			{
				that(product.getName() == null || product.getName().length() >= 3 && product.getName().length() <= 100,"erro", "product.nome.tamanho.invalido");
				that(product.getDescription() != null && product.getDescription().length() > 0 ,"erro", "product.descricao.vazia");
			}
		});
		validator.onErrorUsePageOf(this).newProduct();
		
		dao.create(product);
		result.redirectTo(this).index();
	}
	
	@Put("")
	public void update(Product product) {
		validator.validate(product);
		validator.onErrorUsePageOf(this).edit(product);		
		dao.update(product);
		result.redirectTo(this).index();
	}
	
	@Get({"/{product.id}/edit"})
	public Product edit(Product product){
		return dao.find(product.getId());
	}
	
	@Delete("/{product.id}")
	public void destroy(Product product){
		product = dao.find(product.getId());
		dao.destroy(product);
		result.redirectTo(this).index();
	}
	
	@Get({"/{id}"})
	public Product show(long id){
		return dao.find(id);		
	}
	
	@Get({"/{id}/xml"})
	public void toXML(long id){
		Product product = dao.find(id);
		result.use(Results.xml()).from(product).serialize();
	}
	
	@Get({"/{id}/json"})
	public void toJson(long id){
		Product product = dao.find(id);
		result.use(Results.json()).from(product).serialize();
	}
	
}