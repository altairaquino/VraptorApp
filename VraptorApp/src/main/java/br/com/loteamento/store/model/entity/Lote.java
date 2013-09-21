package br.com.loteamento.store.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=60)
	private String nome;
	
	@ManyToOne	
	private Loteamento loteamento;

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

	public Loteamento getLoteamento() {
		return loteamento;
	}

	public void setLoteamento(Loteamento loteamento) {
		this.loteamento = loteamento;
	}
}
