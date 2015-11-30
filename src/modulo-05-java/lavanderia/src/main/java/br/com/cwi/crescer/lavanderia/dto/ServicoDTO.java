package br.com.cwi.crescer.lavanderia.dto;

import br.com.cwi.crescer.lavanderia.domain.Servico;

public class ServicoDTO {
	
	private Long id;
	private String descricao;
	
	public ServicoDTO(){
	}
	
	public ServicoDTO(Servico entity) {
		this.id = entity.getIdServico();
		this.descricao = entity.getDescricao();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
