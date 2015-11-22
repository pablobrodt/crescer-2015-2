package br.com.cwi.crescer.lavanderia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.ClienteDao;
import br.com.cwi.crescer.lavanderia.domain.Cliente;

@Service
public class ClienteService {
	
	private ClienteDao clienteDao;
	
	@Autowired
	public ClienteService(ClienteDao clienteDao){
		super();
		this.clienteDao = clienteDao;
	}
	
	public Cliente findById(Long id){
		return clienteDao.findById(id);
	}
	
}
