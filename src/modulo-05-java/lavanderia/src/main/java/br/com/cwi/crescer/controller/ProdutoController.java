package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.cwi.crescer.lavanderia.service.ProdutoService;

@Controller
public class ProdutoController {

	private ProdutoService ps;
	
	@Autowired
	public ProdutoController(ProdutoService produtoService){
		super();
		this.ps = produtoService;
	}
	
}
