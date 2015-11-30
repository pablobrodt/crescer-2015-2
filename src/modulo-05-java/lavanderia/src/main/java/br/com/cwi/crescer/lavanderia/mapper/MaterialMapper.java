package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.dto.MaterialDTO;

public class MaterialMapper {
	
	public static Material toEntity(MaterialDTO dto){
		Material entity = new Material();
		entity.setIdMaterial(dto.getId());
		entity.setDescricao(dto.getDescricao());
	
		return entity;
	}
	
	public static MaterialDTO toDTO(Material entity){
		return new MaterialDTO(entity);
	}
}
