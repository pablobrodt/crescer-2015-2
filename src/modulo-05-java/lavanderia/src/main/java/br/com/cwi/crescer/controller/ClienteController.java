package br.com.cwi.crescer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.dto.CidadeDTO;
import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;
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
	
	@RequestMapping(path = "/Editar/{id}", method = RequestMethod.GET)
	public ModelAndView viewEditar(@PathVariable("id") Long id){
		return new ModelAndView("cliente/editar", "cliente", ClienteMapper.toDTO(clienteService.findById(id)));
	}
	
	@RequestMapping(path = "/Editar", method = RequestMethod.POST)
	public ModelAndView editar(@Valid @ModelAttribute("cliente") ClienteDTO dto,
	        					BindingResult result,
	        					final RedirectAttributes redirectAttributes){
								
		if (result.hasErrors()) {
		    return new ModelAndView("cliente/editar");
		}
		
		this.clienteService.update(dto);
		return new ModelAndView("redirect:/Clientes");
	}
	
	@RequestMapping(path = "/Novo", method = RequestMethod.GET)
	public ModelAndView viewIncluir(){
		return new ModelAndView("cliente/incluir", "cliente", new ClienteDTO());
	}
	
	@RequestMapping(path = "/Novo", method = RequestMethod.POST)
	public ModelAndView incluir(@Valid @ModelAttribute("cliente") ClienteDTO dto,
								BindingResult result,
								final RedirectAttributes redirectAttributes){
			
		if (result.hasErrors()) {
		return new ModelAndView("cliente/incluir");
		}

		this.clienteService.insert(dto);
		return new ModelAndView("redirect:/Clientes");
	}
	
	@RequestMapping(path = "/Remover/{id}", method = RequestMethod.GET)
	public ModelAndView viewRemover(@PathVariable("id") Long id){
		return new ModelAndView("cliente/remover", "cliente", ClienteMapper.toDTO(this.clienteService.findById(id)));
	}
	
	@RequestMapping(path = "/Remover", method = RequestMethod.POST)
	public ModelAndView remover(ClienteDTO dto, final RedirectAttributes redirectAttributes){
		this.clienteService.delete(dto.getId());
		
		redirectAttributes.addFlashAttribute("mensagem", "Removido com sucesso!");
		
		return new ModelAndView("redirect:/Clientes");
	}
	
	@ModelAttribute("cidades")
    public List<CidadeDTO> comboCidades() {
        return CidadeMapper.toDtoList(cidadeService.findAll());
    }
}
