package br.com.cwi.crescer.lavanderia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.CidadeDao;
import br.com.cwi.crescer.lavanderia.domain.Cidade;
import br.com.cwi.crescer.lavanderia.dto.CidadeDTO;

@Service
public class CidadeService {
	
	private CidadeDao cidadeDao;
	
	@Autowired
	public CidadeService(CidadeDao cidadeDao){
		super();
		this.cidadeDao = cidadeDao;
	}
	
	public Cidade findById(Long id){
		return this.cidadeDao.findById(id);
	}

	public List<Cidade> findAll() {
		return this.cidadeDao.findAll();
	}
}	
