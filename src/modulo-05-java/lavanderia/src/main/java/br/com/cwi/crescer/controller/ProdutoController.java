package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.service.ProdutoService;

@Controller
@RequestMapping("/Produtos")
public class ProdutoController {

	private ProdutoService ps;
	
	@Autowired
	public ProdutoController(ProdutoService produtoService){
		this.ps = produtoService;
	}
	
	
	public String index(Model model){
		
		Produto produto = this.ps.findById(1L);
		
		model.addAttribute("IDProduto", produto.getIdProduto());
		model.addAttribute("Valor", produto.getValor());
		
		return "produto/index";
	}
}
