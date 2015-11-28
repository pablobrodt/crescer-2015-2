package br.com.cwi.crescer.controller.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.controller.urlmapper.ClienteUrl;
import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;
import br.com.cwi.crescer.lavanderia.service.CidadeService;
import br.com.cwi.crescer.lavanderia.service.ClienteService;
@Controller
@RequestMapping(ClienteUrl.NOVO)
public class ClienteNovoController extends ClienteController{

	@Autowired
	public ClienteNovoController(ClienteService clienteService, CidadeService cidadeService) {
		super(clienteService, cidadeService);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewIncluir(){
		return new ModelAndView("cliente/incluir", "cliente", new ClienteDTO());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView incluir(@Valid @ModelAttribute("cliente") ClienteDTO dto,
								BindingResult result,
								final RedirectAttributes redirectAttributes){
		
		redirectAttributes.addFlashAttribute("mensagem", "Inserido com sucesso!");
		
		if (result.hasErrors()) {
		return new ModelAndView("cliente/incluir");
		}

		this.clienteService.insert(dto);
		return new ModelAndView("redirect:/Clientes");
	}
}
