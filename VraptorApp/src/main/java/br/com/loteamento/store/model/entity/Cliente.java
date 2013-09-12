package br.com.loteamento.store.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=60)
	private String nome;
	
	@Column(length=20)
	private String cpf;
	
	@Column(length=60)
	private String logradouro;
	
	@Column(length=15)
	private String numeroLogradouro;
	
	@Column(length=30)
	private String complementoLogradouro;
	
	@Column(length=30)
	private String bairro;
	
	@Column(length=30)
	private String cidade;
	
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}