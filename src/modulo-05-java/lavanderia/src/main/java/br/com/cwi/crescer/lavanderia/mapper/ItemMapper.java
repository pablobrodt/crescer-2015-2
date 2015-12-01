package br.com.cwi.crescer.lavanderia.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.dto.ItemDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;

public class ItemMapper {
	
	private static BigDecimal formatarDecimal(BigDecimal number){
		return number != null ? number.setScale(2, BigDecimal.ROUND_HALF_UP) : number;
	}
	
	public static Item toEntity(ItemDTO dto, Pedido pedido){
		Item entity = new Item();
		entity.setIdItem(dto.getIdItem());
		entity.setPedido(pedido);
		entity.setProduto(ProdutoMapper.toEntity(dto.getProduto()));
		entity.setPeso(formatarDecimal(dto.getPeso()));
		entity.setValorUnitario(formatarDecimal(dto.getValorUnitario()));
		entity.setValorTotal(formatarDecimal(dto.getValorTotal()));
		entity.setSituacao(dto.getSituacao());
		
		return entity;
	}
	
	public static ItemDTO toDTO(Item entity, PedidoDTO pedidoDTO){
		ItemDTO dto = new ItemDTO();
		dto.setIdItem(entity.getIdItem());
		dto.setPedido(entity.getPedido().getIdPedido());
		dto.setProduto(ProdutoMapper.toDTO(entity.getProduto()));
		dto.setPeso(formatarDecimal(entity.getPeso()));
		dto.setValorUnitario(formatarDecimal(entity.getValorUnitario()));
		dto.setValorTotal(formatarDecimal(entity.getValorTotal()));
		dto.setSituacao(entity.getSituacao());
		
		return dto;
	}
	
	public static List<Item> toEntityList(List<ItemDTO> dtoList, Pedido pedido){
		List<Item> entityList = new ArrayList<Item>();
		for (ItemDTO itemDTO : dtoList) {
			entityList.add(toEntity(itemDTO, pedido));
		}
		return entityList;
	}
	
	public static List<ItemDTO> toDTOList(List<Item> entityList, PedidoDTO pedidoDTO) {
		List<ItemDTO> dtoList = new ArrayList<ItemDTO>();
		for (Item item : entityList) {
			dtoList.add(toDTO(item, pedidoDTO));
		}
		return dtoList;
	}
	
}
