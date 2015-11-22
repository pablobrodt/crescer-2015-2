package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.service.ClienteService;

@Controller
public class ClienteController {
	
	private ClienteService cs;
	
	@Autowired
	public ClienteController(ClienteService clienteService){
		super();
		this.cs = clienteService;
	}
	
	@RequestMapping("/Cliente/")
	public String index(Model model){
		
		Cliente cliente = this.cs.findById(1L);
		
		model.addAttribute("Nome", cliente.getNome());
		model.addAttribute("Cpf", cliente.getCpf());
		model.addAttribute("Endereco", cliente.getEndereco());
		model.addAttribute("Bairro", cliente.getBairro());
		model.addAttribute("Email", cliente.getEmail());
		
		return "cliente/index";
	}
	
}
