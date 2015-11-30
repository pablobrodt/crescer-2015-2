package br.com.cwi.crescer.lavanderia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.ProdutoDao;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.dto.MaterialDTO;
import br.com.cwi.crescer.lavanderia.dto.ProdutoDTO;
import br.com.cwi.crescer.lavanderia.mapper.ProdutoMapper;

@Service
public class ProdutoService {
	
	private ProdutoDao produtoDao;
	
	@Autowired
	public ProdutoService(ProdutoDao produtoDao){
		this.produtoDao = produtoDao;
	}
	
	public Produto findById(Long id){
		return this.produtoDao.findById(id);
	}

	public List<ProdutoDTO> findByServico(Long idServico) {
		List<ProdutoDTO> produtos = new ArrayList<>();
		for (Produto produto : this.produtoDao.findByServico(idServico)) {
			produtos.add(ProdutoMapper.toDTO(produto));
		}
		return produtos;
	}

	public ProdutoDTO findByServicoMaterial(Long idServico, Long idMaterial) {
		return ProdutoMapper.toDTO(this.produtoDao.findByServicoMaterial(idServico, idMaterial));
	}
}
