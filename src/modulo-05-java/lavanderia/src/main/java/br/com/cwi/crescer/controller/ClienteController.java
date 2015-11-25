package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import br.com.cwi.crescer.lavanderia.dto.CidadeDTO;
import br.com.cwi.crescer.lavanderia.mapper.CidadeMapper;
import br.com.cwi.crescer.lavanderia.mapper.ClienteMapper;
import br.com.cwi.crescer.lavanderia.service.CidadeService;
import br.com.cwi.crescer.lavanderia.service.ClienteService;

@Controller
@RequestMapping("/Clientes")
public class ClienteController {
	
	private ClienteService clienteService;
	private CidadeService cidadeService;
	
	@Autowired
	public ClienteController(ClienteService clienteService, CidadeService cidadeService){
		this.clienteService = clienteService;
		this.cidadeService = cidadeService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		return new ModelAndView("cliente/listar", "clientes", this.clienteService.findAllActive());
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView exibe(@PathVariable("id") Long id){
		return new ModelAndView("cliente/exibe", "cliente", ClienteMapper.toDTO(this.clienteService.findById(id)));
	}
	
	@ModelAttribute("cidades")
    public List<CidadeDTO> comboCidades() {
        return CidadeMapper.toDtoList(cidadeService.findAll());
    }
}
