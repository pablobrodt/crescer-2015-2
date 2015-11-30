package br.com.cwi.crescer.lavanderia.dto;

import br.com.cwi.crescer.lavanderia.domain.Material;

public class MaterialDTO {
	
	private Long id;
	private String descricao;
	
	public MaterialDTO(){
	}
	
	public MaterialDTO(Material entity) {
		this.id = entity.getIdMaterial();
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
	
