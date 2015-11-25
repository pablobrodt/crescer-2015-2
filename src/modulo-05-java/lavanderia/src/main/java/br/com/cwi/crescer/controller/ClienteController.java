package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.lavanderia.service.ClienteService;

@Controller
@RequestMapping("/Clientes")
public class ClienteController {
	
	private ClienteService cs;
	
	@Autowired
	public ClienteController(ClienteService clienteService){
		this.cs = clienteService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		return new ModelAndView("cliente/listar", "clientes", cs.findAllActive());
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView exibe(@PathVariable("id") Long id){
		return new ModelAndView("cliente.exibe", "cliente", cs.findById(id));
	}
	
}
