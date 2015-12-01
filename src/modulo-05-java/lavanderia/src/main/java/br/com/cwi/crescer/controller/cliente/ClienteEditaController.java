package br.com.cwi.crescer.controller.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.controller.urlmapper.ClienteUrl;
import br.com.cwi.crescer.exception.Mensagem;
import br.com.cwi.crescer.exception.Mensagem.TipoMensagem;
import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;
import br.com.cwi.crescer.lavanderia.service.CidadeService;
import br.com.cwi.crescer.lavanderia.service.ClienteService;

@Controller
@RequestMapping(ClienteUrl.EDITA)
public class ClienteEditaController extends ClienteController{

	@Autowired
	public ClienteEditaController(ClienteService clienteService, CidadeService cidadeService) {
		super(clienteService, cidadeService);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewEditar(@PathVariable("id") Long id){
		return new ModelAndView("cliente/editar", "cliente", this.clienteService.findById(id));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView editar(@Valid @ModelAttribute("cliente") ClienteDTO dto,
	        					BindingResult result,
	        					final RedirectAttributes redirectAttributes){
		
		redirectAttributes.addFlashAttribute("mensagem", new Mensagem("Alterado com sucesso!", TipoMensagem.ERROR));
								
		if (result.hasErrors()) {
		    return new ModelAndView("cliente/editar");
		}
		
		this.clienteService.update(dto);
		return new ModelAndView("redirect:"+ClienteUrl.LISTA);
	}
}
