package br.com.cwi.crescer.lavanderia.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.lavanderia.domain.Cidade;
import br.com.cwi.crescer.lavanderia.dto.CidadeDTO;

public class CidadeMapper {
	
	public static CidadeDTO toDTI(Cidade entity){
		CidadeDTO dto = new CidadeDTO();
		dto.setId(entity.getIdCidade());
		dto.setNome(entity.getNome());
		dto.setUf(entity.getUf());
		
		return dto;
	}
	
	public static Cidade toEntity(CidadeDTO dto){
		Cidade entity = new Cidade();
		entity.setIdCidade(dto.getId());
		entity.setNome(dto.getNome());
		entity.setUf(dto.getUf());
		
		return entity;
	}
	
	public static List<CidadeDTO> toDtoList(List<Cidade> entityList){
		
		List<CidadeDTO> listDTO = new ArrayList<CidadeDTO>();
		for (Cidade entity : entityList) {
			listDTO.add(new CidadeDTO(entity));
		}
		
		return listDTO;
	}
}
