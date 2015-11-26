package br.com.cwi.crescer.lavanderia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.CidadeDao;
import br.com.cwi.crescer.lavanderia.dao.ClienteDao;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;
import br.com.cwi.crescer.lavanderia.dto.ClienteResumoDTO;
import br.com.cwi.crescer.lavanderia.mapper.ClienteMapper;

@Service
public class ClienteService {
	
	private ClienteDao clienteDao;
	private CidadeDao cidadeDao;
	
	@Autowired
	public ClienteService(ClienteDao clienteDao, CidadeDao cidadeDao){
		this.clienteDao = clienteDao;
		this.cidadeDao = cidadeDao;
	}
	
	public Cliente findById(Long id){
		return clienteDao.findById(id);
	}

	public List<ClienteResumoDTO> findAllActive() {
		List<Cliente> clientes = clienteDao.findBySituacao(SituacaoCliente.ATIVO);
		
		List<ClienteResumoDTO> dtos = ClienteMapper.toClienteResumoDtoList(clientes);
		
		return dtos;
	}

	public void update(ClienteDTO dto) {
		
		Cliente entity = this.clienteDao.findById(dto.getId());
		ClienteMapper.merge(dto,  entity);
		entity.setCidade(this.cidadeDao.findById(dto.getIdCidade()));
		
		this.clienteDao.save(entity);
	}

	public void insert(ClienteDTO dto) {
		Cliente entity = new Cliente();
		ClienteMapper.merge(dto,  entity);
		entity.setCidade(this.cidadeDao.findById(dto.getIdCidade()));
		entity.setSituacao(SituacaoCliente.ATIVO);
		
		this.clienteDao.save(entity);
	}

	public void delete(Long id) {
		Cliente entity = findById(id);
		entity.setSituacao(SituacaoCliente.INATIVO);
		
		this.clienteDao.save(entity);
	}
}
