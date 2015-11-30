package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.dto.ProdutoDTO;

public class ProdutoMapper {
	
	public static Produto toEntity(ProdutoDTO dto){
		Produto entity = new Produto();
		entity.setIdProduto(dto.getIdProduto());
		entity.setMaterial(MaterialMapper.toEntity(dto.getMaterial()));
		entity.setServico(ServicoMapper.toEntity(dto.getServico()));
		entity.setPrazo(dto.getPrazo());
		entity.setValor(dto.getValor());
		
		return entity;
	}
	
	public static ProdutoDTO toDTO(Produto entity){
		ProdutoDTO dto = new ProdutoDTO();
		dto.setIdProduto(entity.getIdProduto());
		dto.setMaterial(MaterialMapper.toDTO(entity.getMaterial()));
		dto.setServico(ServicoMapper.toDTO(entity.getServico()));
		dto.setPrazo(entity.getPrazo());
		dto.setValor(entity.getValor());
		
		return dto;
	}
	
}
