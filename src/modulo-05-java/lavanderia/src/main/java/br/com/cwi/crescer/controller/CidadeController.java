package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.lavanderia.domain.Cidade;
import br.com.cwi.crescer.lavanderia.service.CidadeService;

@Controller
public class CidadeController {
	
	private CidadeService cs;
	
	@Autowired
	public CidadeController(CidadeService cidadeService){
		super();
		this.cs = cidadeService;
	}
	
	@RequestMapping("/Cidade/")
	public String index(Model model){
		
		Cidade c = cs.findById(1L);
		
		model.addAttribute("Cidade", c.getNome());
		model.addAttribute("UF", c.getUf());
		
		return "cidade/index";
	}
	
}
