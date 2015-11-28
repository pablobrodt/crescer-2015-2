package br.com.cwi.crescer.controller.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.controller.urlmapper.ClienteUrl;
import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;
import br.com.cwi.crescer.lavanderia.service.CidadeService;
import br.com.cwi.crescer.lavanderia.service.ClienteService;

@Controller
@RequestMapping(ClienteUrl.REMOVE)
public class ClienteRemoverController extends ClienteController{

	@Autowired
	public ClienteRemoverController(ClienteService clienteService, CidadeService cidadeService) {
		super(clienteService, cidadeService);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewRemover(@PathVariable("id") Long id){
		return new ModelAndView("cliente/remover", "cliente", this.clienteService.findById(id));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView remover(ClienteDTO dto, final RedirectAttributes redirectAttributes){
		this.clienteService.delete(dto.getId());
		
		redirectAttributes.addFlashAttribute("mensagem", "Removido com sucesso!");
		
		return new ModelAndView("redirect:" + ClienteUrl.LISTA);
	}
}
