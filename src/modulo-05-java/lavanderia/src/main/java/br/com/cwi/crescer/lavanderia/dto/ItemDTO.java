package br.com.cwi.crescer.lavanderia.dto;

import java.math.BigDecimal;

import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;

public class ItemDTO {
	
	private Long idItem;
	private PedidoDTO pedido;
	private ProdutoDTO produto;
	private BigDecimal peso;
	private BigDecimal valorUnitario;
	private BigDecimal valorTotal;
	private SituacaoItem situacao;
	
	
	public Long getIdItem() {
		return idItem;
	}
	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}
	public PedidoDTO getPedido() {
		return pedido;
	}
	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}
	public ProdutoDTO getProduto() {
		return produto;
	}
	public void setProduto(ProdutoDTO produto) {
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
}
