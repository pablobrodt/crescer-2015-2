package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.service.ServicoService;

@Controller
public class ServicoController {
	
	private ServicoService ss;
	
	@Autowired
	public ServicoController(ServicoService servicoService){
		super();
		this.ss = servicoService;
	}
	
	@RequestMapping("/Servico/")
	public String index(Model model){
		
		Servico servico = this.ss.findById(1L);
		
		model.addAttribute("Descricao", servico.getDescricao());
		
		return "servico/index";
	}
}
