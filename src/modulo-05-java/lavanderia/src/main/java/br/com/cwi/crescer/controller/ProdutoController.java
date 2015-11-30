package br.com.cwi.crescer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.dto.MaterialDTO;
import br.com.cwi.crescer.lavanderia.dto.ProdutoDTO;
import br.com.cwi.crescer.lavanderia.service.ProdutoService;

@Controller
@RequestMapping("/Produtos")
public class ProdutoController {

	private ProdutoService produtoService;
	
	@Autowired
	public ProdutoController(ProdutoService produtoService){
		this.produtoService = produtoService;
	}
	
	@ResponseBody
	@RequestMapping(path = "/rest/{id}")
	public List<ProdutoDTO> buscarPorServico(@PathVariable("id") Long id) {
	    return produtoService.findByServico(id);
	}
	
	@ResponseBody
	@RequestMapping(path = "/rest/{idServico}/{idMaterial}")
	public ProdutoDTO buscarPorServico(@PathVariable("idServico") Long idServico, 
											@PathVariable("idMaterial") Long idMaterial) {
	    return produtoService.findByServicoMaterial(idServico, idMaterial);
	}
}
