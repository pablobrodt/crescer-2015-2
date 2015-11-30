package br.com.cwi.crescer.lavanderia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.ServicoDao;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.dto.ServicoDTO;

@Service
public class ServicoService {
	
	private ServicoDao servicoDao;
	
	@Autowired
	public ServicoService(ServicoDao servicoDao){
		super();
		this.servicoDao = servicoDao;
	}
	
	public Servico findById(Long id){
		return this.servicoDao.findById(id);
	}

	public List<ServicoDTO> findAll() {
		List<ServicoDTO> servicos = new ArrayList<>();
		for (Servico servico : this.servicoDao.findAll()) {
			servicos.add(new ServicoDTO(servico));
		}
		return servicos;
	}
}
