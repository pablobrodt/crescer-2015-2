package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.dto.ServicoDTO;

public class ServicoMapper {
	
	public static Servico toEntity(ServicoDTO dto){
		Servico entity = new Servico();
		entity.setIdServico(dto.getId());
		entity.setDescricao(dto.getDescricao());
	
		return entity;
	}
	
	public static ServicoDTO toDTO(Servico entity){
		return new ServicoDTO(entity);
	}
	
}
