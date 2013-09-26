package br.com.loteamento.store.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Loteamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length=60)
	private String nome;
	
	@Column(length=500)
	private String descricao;
	
	@ManyToOne
	@JoinColumn
	private TipoLoteamento tipoLoteamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoLoteamento getTipoLoteamento() {
		return tipoLoteamento;
	}

	public void setTipoLoteamento(TipoLoteamento tipoLoteamento) {
		this.tipoLoteamento = tipoLoteamento;
	}
	
}