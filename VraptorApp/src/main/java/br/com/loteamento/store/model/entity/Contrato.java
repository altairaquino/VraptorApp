package br.com.loteamento.store.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn
	@ManyToOne(fetch=FetchType.LAZY)
	private Cliente cliente;
	
	@JoinColumn
	@ManyToOne(fetch=FetchType.LAZY)
	private Lote lote;
	
	@JoinColumn
	@ManyToOne(fetch=FetchType.LAZY)
	private FormaPagamento formaPagamento;
	
	@Column(length=60)
	private String nome;
	
	private StatusContrato statusContrato;
	
	private Float valorTotal;
	private Float valorEntrada;
	private Float percentualJuros;
	private Float percentualMulta;
	
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public StatusContrato getStatusContrato() {
		return statusContrato;
	}

	public void setStatusContrato(StatusContrato statusContrato) {
		this.statusContrato = statusContrato;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Float getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(Float valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public Float getPercentualJuros() {
		return percentualJuros;
	}

	public void setPercentualJuros(Float percentualJuros) {
		this.percentualJuros = percentualJuros;
	}

	public Float getPercentualMulta() {
		return percentualMulta;
	}

	public void setPercentualMulta(Float percentualMulta) {
		this.percentualMulta = percentualMulta;
	}	

}