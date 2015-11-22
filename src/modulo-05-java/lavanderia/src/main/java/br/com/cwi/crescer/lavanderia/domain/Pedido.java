package br.com.cwi.crescer.lavanderia.domain;

import java.math.BigDecimal;
import java.util.Date;
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
	private int idPedido;
	private int idCliente;
	private Date dataInclusao;
	private Date dataentrega;
	private BigDecimal valor;
	private String situacao;
	
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
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
