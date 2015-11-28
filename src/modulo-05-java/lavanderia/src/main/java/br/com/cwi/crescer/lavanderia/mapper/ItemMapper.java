package br.com.cwi.crescer.lavanderia.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.dto.ItemDTO;

public class ItemMapper {
	
	//TODO: IMPLEMENTAR CONVERSAO DE LISTA DE DTO PARA ENTITY
	public static List<Item> toEntityList(List<ItemDTO> dtoList){
		return new ArrayList<Item>();
	}
	
	//TODO: IMPLEMENTAR CONVERSAO DE LISTA DE ENTITY PARA DTO
	public static List<ItemDTO> toDTOList(List<Item> itens) {
		return new ArrayList<ItemDTO>();
	}
	
}
