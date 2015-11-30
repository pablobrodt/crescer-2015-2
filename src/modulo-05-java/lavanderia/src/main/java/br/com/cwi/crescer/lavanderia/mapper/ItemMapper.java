package br.com.cwi.crescer.lavanderia.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.dto.ItemDTO;

public class ItemMapper {
	
	public static Item toEntity(ItemDTO dto){
		Item entity = new Item();
		entity.setIdItem(dto.getIdItem());
		entity.setPedido(PedidoMapper.toEntity(dto.getPedido()));
		entity.setProduto(ProdutoMapper.toEntity(dto.getProduto()));
		entity.setPeso(dto.getPeso());
		entity.setValorUnitario(dto.getValorUnitario());
		entity.setValorDesconto(dto.getValorDesconto());
		entity.setValorTotal(dto.getValorTotal());
		
		return entity;
	}
	
	public static ItemDTO toDTO(Item entity){
		ItemDTO dto = new ItemDTO();
		dto.setIdItem(entity.getIdItem());
		dto.setPedido(PedidoMapper.toDTO(entity.getPedido()));
		dto.setProduto(ProdutoMapper.toDTO(entity.getProduto()));
		dto.setPeso(entity.getPeso());
		dto.setValorUnitario(entity.getValorUnitario());
		dto.setValorDesconto(entity.getValorDesconto());
		dto.setValorTotal(entity.getValorTotal());
		
		return dto;
	}
	
	public static List<Item> toEntityList(List<ItemDTO> dtoList){
		List<Item> entityList = new ArrayList<Item>();
		for (ItemDTO itemDTO : dtoList) {
			entityList.add(toEntity(itemDTO));
		}
		return entityList;
	}
	
	public static List<ItemDTO> toDTOList(List<Item> entityList) {
		List<ItemDTO> dtoList = new ArrayList<ItemDTO>();
		for (Item item : entityList) {
			dtoList.add(toDTO(item));
		}
		return dtoList;
	}
	
}
