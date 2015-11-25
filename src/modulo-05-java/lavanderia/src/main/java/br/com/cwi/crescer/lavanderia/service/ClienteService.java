package br.com.cwi.crescer.lavanderia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.ClienteDao;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.lavanderia.dto.ClienteResumoDTO;
import br.com.cwi.crescer.lavanderia.mapper.ClienteMapper;

@Service
public class ClienteService {
	
	private ClienteDao clienteDao;
	
	@Autowired
	public ClienteService(ClienteDao clienteDao){
		this.clienteDao = clienteDao;
	}
	
	public Cliente findById(Long id){
		return clienteDao.findById(id);
	}

	public List<ClienteResumoDTO> findAllActive() {
		List<Cliente> clientes = clienteDao.findBySituacao(SituacaoCliente.ATIVO);
		
		List<ClienteResumoDTO> dtos = ClienteMapper.toClienteResumoDtoList(clientes);
		
		return dtos;
	}
}
