package br.com.cwi.crescer.lavanderia.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Pedido")
@SequenceGenerator(name = Pedido.SEQUENCE_NAME,
sequenceName = Pedido.SEQUENCE_NAME)
public class Pedido {
	
	public static final String SEQUENCE_NAME = "SEQ_Pedido";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "IDPedido")
	private Long idPedido;
	
	@Column(name = "IDCliente")
	@Basic(optional = false)
	private Long idCliente;
	
	@Column(name = "DataInclusao")
	@Basic(optional = false)
	private Date dataInclusao;
	
	@Column(name = "DataEntrega")
	private Date dataentrega;
	
	@Column(name = "Valor")
	@Basic(optional = false)
	private BigDecimal valor;
	
	@Column(name = "Situacao")
	private String situacao;
	
	
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public Date getDataentrega() {
		return dataentrega;
	}
	public void setDataentrega(Date dataentrega) {
		this.dataentrega = dataentrega;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	 
}