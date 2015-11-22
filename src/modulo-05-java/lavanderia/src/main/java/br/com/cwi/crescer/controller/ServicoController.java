package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.cwi.crescer.lavanderia.service.ServicoService;

@Controller
public class ServicoController {
	
	private ServicoService ss;
	
	@Autowired
	public ServicoController(ServicoService servicoService){
		super();
		this.ss = servicoService;
	}
	
}
