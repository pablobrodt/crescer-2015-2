package br.com.cwi.crescer.lavanderia.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.lavanderia.domain.Cidade;
import br.com.cwi.crescer.lavanderia.dto.CidadeDTO;

public class CidadeMapper {
	
	public static List<CidadeDTO> toListCidadeDTO(List<Cidade> entityList){
		
		List<CidadeDTO> listDTO = new ArrayList<CidadeDTO>();
		for (Cidade entity : entityList) {
			listDTO.add(new CidadeDTO(entity));
		}
		
		return listDTO;
	}
}
