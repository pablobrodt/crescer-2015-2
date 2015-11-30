package br.com.cwi.crescer.lavanderia.dto;

import java.math.BigDecimal;

import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.domain.Servico;

public class ProdutoDTO {
	
	private Long idProduto;
	private Servico servico;
	private Material material;
	private BigDecimal valor;
	private Long prazo;
	
	public ProdutoDTO(){
	}
	
	public ProdutoDTO(Produto entity){
		this.idProduto = entity.getIdProduto();
		this.servico = entity.getServico();
		this.material = entity.getMaterial();
		this.valor = entity.getValor();
		this.prazo = entity.getPrazo();
	}
	
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Long getPrazo() {
		return prazo;
	}
	public void setPrazo(Long prazo) {
		this.prazo = prazo;
	}
}
