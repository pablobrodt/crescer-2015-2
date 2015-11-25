package br.com.cwi.crescer.lavanderia.dto;

import br.com.cwi.crescer.lavanderia.domain.Cidade;

public class CidadeDTO {
	
	private Long id;
	private String nome;
	private String uf;
	
	public CidadeDTO(){
	}
	
	public CidadeDTO(Cidade entity) {
		this.id = entity.getIdCidade();
		this.nome = entity.getNome();
		this.uf = entity.getUf();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long idCidade) {
		this.id = idCidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
}
