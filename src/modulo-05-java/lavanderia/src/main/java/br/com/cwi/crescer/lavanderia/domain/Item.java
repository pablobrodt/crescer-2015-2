package br.com.cwi.crescer.lavanderia.domain;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
@SequenceGenerator(name = Item.SEQUENCE_NAME,
sequenceName = Item.SEQUENCE_NAME, initialValue = 1, allocationSize = 1)
public class Item {
	
	public static final String SEQUENCE_NAME = "SEQ_Item";
	
	public Item(){
	}
	
	public Item(Produto produto) {
		this.produto = produto;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "IDItem")
	private Long idItem;
	
	@ManyToOne
	@JoinColumn(name = "IDPedido")
	@Basic(optional = false)
	private Pedido pedido;
	
	@OneToOne
	@JoinColumn(name = "IDProduto")
	@Basic(optional = false)
	private Produto produto;
	
	@Column(name = "Peso")
	@Basic(optional = false)
	private BigDecimal peso;
	
	@Column(name = "VALORUnitario")
	@Basic(optional = false)
	private BigDecimal valorUnitario;
	
	@Column(name = "VALORTotal")
	@Basic(optional = false)
	private BigDecimal valorTotal;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Situacao", length = 1)
	private SituacaoItem situacao;
	
	public static enum SituacaoItem {
        PENDENTE, PROCESSADO
    }
	
	public Long getIdItem() {
		return idItem;
	}
	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public BigDecimal getPeso() {
		return peso;
	}
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public SituacaoItem getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoItem situacao) {
		this.situacao = situacao;
	}
	
	public Long getPrazo(){
		return this.produto.getPrazo();
	}
	
	public void tornarPendente(){
		this.situacao = SituacaoItem.PENDENTE;
	}
}
