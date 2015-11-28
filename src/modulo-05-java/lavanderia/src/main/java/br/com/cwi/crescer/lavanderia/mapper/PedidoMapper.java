package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;

public class PedidoMapper {
	
	public Pedido toEntity(PedidoDTO dto){
		Pedido entity = new Pedido();
		entity.setIdPedido(dto.getIdPedido());
		entity.setCliente(ClienteMapper.toEntity(dto.getCliente()));
		entity.setDataEntrega(dto.getDataEntrega());
		entity.setDataInclusao(dto.getDataInclusao());
		entity.setItens(ItemMapper.toEntityList(dto.getItens()));
		entity.setSituacao(dto.getSituacao());
		entity.setValorBruto(dto.getValorBruto());
		entity.setValorDesconto(dto.getValorDesconto());
		entity.setValorFinal(dto.getValorBruto());
		
		return entity;
	}
	
	public PedidoDTO toDTO(Pedido entity){
		PedidoDTO dto = new PedidoDTO();
		dto.setIdPedido(entity.getIdPedido());
		dto.setCliente(ClienteMapper.toDTO(entity.getCliente()));
		dto.setDataEntrega(entity.getDataEntrega());
		dto.setDataInclusao(entity.getDataInclusao());
		dto.setItens(ItemMapper.toDTOList(entity.getItens()));
		dto.setSituacao(entity.getSituacao());
		dto.setValorBruto(entity.getValorBruto());
		dto.setValorDesconto(entity.getValorDesconto());
		dto.setValorFinal(entity.getValorBruto());
		
		return dto;
	}
	
}
