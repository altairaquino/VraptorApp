package br.com.m2msolutions.grumobile.model.bean;

import java.io.Serializable;

public class Tabela implements Serializable {

	private static final long serialVersionUID = 8424923132705947804L;
	
	private Long id;
	private String codigo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}	

}