package br.com.cwi.crescer.lavanderia.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoResumoDTO;

public class PedidoMapper {
	
	public static Pedido toEntity(PedidoDTO dto){
		Pedido entity = new Pedido();
		entity.setIdPedido(dto.getIdPedido());
		entity.setCliente(ClienteMapper.toEntity(dto.getCliente()));
		entity.setDataEntrega(dto.getDataEntrega());
		entity.setDataInclusao(dto.getDataInclusao());
		entity.setItens(ItemMapper.toEntityList(dto.getItens(), entity));
		entity.setSituacao(dto.getSituacao());
		entity.setValorBruto(dto.getValorBruto());
		entity.setValorDesconto(dto.getValorDesconto());
		entity.setValorFinal(dto.getValorBruto());
		
		return entity;
	}
	
	public static PedidoDTO toDTO(Pedido entity){
		PedidoDTO dto = new PedidoDTO();
		dto.setIdPedido(entity.getIdPedido());
		dto.setCliente(ClienteMapper.toDTO(entity.getCliente()));
		dto.setDataEntrega(entity.getDataEntrega());
		dto.setDataInclusao(entity.getDataInclusao());
		dto.setItens(ItemMapper.toDTOList(entity.getItens(), dto));
		dto.setSituacao(entity.getSituacao());
		dto.setValorBruto(entity.getValorBruto());
		dto.setValorDesconto(entity.getValorDesconto());
		dto.setValorFinal(entity.getValorFinal());
		
		return dto;
	}

	public static List<PedidoDTO> toDTOList(List<Pedido> entityList) {
		ArrayList<PedidoDTO> dtoList = new ArrayList<>();
		for (Pedido pedido : entityList) {
			dtoList.add(toDTO(pedido));
		}
		return dtoList;
	}
	
	public static List<Pedido> toEntityList(List<PedidoDTO> dtoList) {
		ArrayList<Pedido> entityList = new ArrayList<>();
		for (PedidoDTO pedidoDTO : dtoList) {
			entityList.add(toEntity(pedidoDTO));
		}
		return entityList;
	}
	
	public static PedidoResumoDTO toResumoDTO(Pedido entity){
		PedidoResumoDTO dto = new PedidoResumoDTO();
		
		Cliente cliente = entity.getCliente();
		
		dto.setId(entity.getIdPedido());
		dto.setCpfCliente(cliente.getCpf());
		dto.setNomeCliente(cliente.getNome());
		dto.setDataInclusao(entity.getDataInclusao());
		dto.setValorTotal(entity.getValorFinal());
		dto.setSituacao(entity.getSituacao());
		
		return dto;
	}
	
	public static List<PedidoResumoDTO> toResumoDTOList(List<Pedido> entityList){
		ArrayList<PedidoResumoDTO> dtoList = new ArrayList<>();
		for (Pedido entity : entityList) {
			dtoList.add(toResumoDTO(entity));
		}
		return dtoList;
	}
}
