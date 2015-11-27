package br.com.cwi.crescer.lavanderia.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.lavanderia.domain.Usuario;
import br.com.cwi.crescer.lavanderia.dto.UsuarioDTO;
import br.com.cwi.crescer.lavanderia.dto.UsuarioResumoDTO;

public class UsuarioMapper {
	
	public static Usuario toEntity(UsuarioDTO dto){
		Usuario entity = new Usuario();
		entity.setUserName(dto.getUserName());
		entity.setPassword(dto.getPassword());
		entity.setAutorizacoes(dto.getAutorizacoes());
		entity.setEnabled(dto.getEnabled());
		
		return entity;
	}
	
	public static UsuarioDTO toDTO(Usuario entity){
		UsuarioDTO dto = new UsuarioDTO();
		dto.setUserName(entity.getUserName());
		dto.setPassword(entity.getPassword());
		dto.setAutorizacoes(entity.getAutorizacoes());
		dto.setEnabled(entity.getEnabled());
		
		return dto;
	}
	
	public static UsuarioResumoDTO toResumoDTO(Usuario entity){
		UsuarioResumoDTO dto = new UsuarioResumoDTO();
		dto.setUserName(entity.getUserName());
		dto.setAutorizacoes(entity.getAutorizacoes());
		dto.setEnabled(entity.getEnabled());
		
		return dto;
	}
	
	public static List<UsuarioResumoDTO> toResumoDTOList(List<Usuario> entities){
		List<UsuarioResumoDTO> dtos = new ArrayList<UsuarioResumoDTO>();
		if(entities.size() > 0){
			for (Usuario entity : entities) {
				dtos.add(toResumoDTO(entity));
			}
		}
		return dtos;
	}

	public static Usuario merge(UsuarioDTO dto, Usuario entity) {
		entity.setUserName(dto.getUserName());
		entity.setPassword(dto.getPassword());
		entity.setAutorizacoes(dto.getAutorizacoes());
		entity.setEnabled(dto.getEnabled());
		
		return entity;
	}
}
