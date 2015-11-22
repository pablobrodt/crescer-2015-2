package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.cwi.crescer.lavanderia.service.ClienteService;

@Controller
public class ClienteController {
	
	private ClienteService cs;
	
	@Autowired
	public ClienteController(ClienteService clienteService){
		super();
		this.cs = clienteService;
	}
	
}
