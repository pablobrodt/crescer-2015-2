package br.com.cwi.crescer.lavanderia.dto;

import java.math.BigDecimal;

import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.domain.Servico;

public class ProdutoDTO {
	
	private Long idProduto;
	private ServicoDTO servico;
	private MaterialDTO material;
	private BigDecimal valor;
	private Long prazo;
	
	public ProdutoDTO(){
	}
	
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public ServicoDTO getServico() {
		return servico;
	}
	public void setServico(ServicoDTO servico) {
		this.servico = servico;
	}
	public MaterialDTO getMaterial() {
		return material;
	}
	public void setMaterial(MaterialDTO material) {
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
