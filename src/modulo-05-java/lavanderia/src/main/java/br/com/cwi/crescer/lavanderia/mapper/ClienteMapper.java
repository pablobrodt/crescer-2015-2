package br.com.cwi.crescer.lavanderia.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.lavanderia.domain.Cidade;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.dto.CidadeDTO;
import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;
import br.com.cwi.crescer.lavanderia.dto.ClienteResumoDTO;

public class ClienteMapper {
	
	public static Cliente toEntitu(ClienteDTO clienteDTO){
		Cliente cliente = new Cliente();
		cliente.setIdCliente(clienteDTO.getId());
		cliente.setNome(clienteDTO.getNome());
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setEndereco(clienteDTO.getEndereco());
		cliente.setBairro(clienteDTO.getBairro());
		
		return cliente;
	}
	
	public static ClienteDTO toDTO(Cliente cliente){
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getIdCliente());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setEndereco(cliente.getEndereco());
		clienteDTO.setBairro(cliente.getBairro());
		clienteDTO.setIdCidade(cliente.getCidade().getIdCidade());
		
		return clienteDTO;
	}
	
	public static Cliente merge(ClienteDTO dto, Cliente entity){
		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());
		entity.setEmail(dto.getEmail());
		entity.setEndereco(dto.getEndereco());
		entity.setBairro(dto.getBairro());
		
		return entity;
	}
	
	public static List<ClienteResumoDTO> toClienteResumoDtoList(List<Cliente> entityList){
		
		List<ClienteResumoDTO> listDTO = new ArrayList<ClienteResumoDTO>();
		for (Cliente entity : entityList) {
			listDTO.add(new ClienteResumoDTO(entity));
		}
		
		return listDTO;
	}
}
