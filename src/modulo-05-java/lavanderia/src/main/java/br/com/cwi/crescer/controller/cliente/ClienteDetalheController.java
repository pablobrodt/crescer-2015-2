package br.com.cwi.crescer.controller.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.controller.urlmapper.ClienteUrl;
import br.com.cwi.crescer.lavanderia.service.CidadeService;
import br.com.cwi.crescer.lavanderia.service.ClienteService;

@Controller
@RequestMapping(ClienteUrl.DETALHE)
public class ClienteDetalheController extends ClienteController{
			
	@Autowired
	public ClienteDetalheController(ClienteService clienteService, CidadeService cidadeService) {
		super(clienteService, cidadeService);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView exibe(@PathVariable("id") Long id){
		return new ModelAndView("cliente/exibe", "cliente", this.clienteService.findById(id));
	}
}
