package br.com.cwi.crescer.controller.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.controller.urlmapper.ClienteUrl;
import br.com.cwi.crescer.lavanderia.service.CidadeService;
import br.com.cwi.crescer.lavanderia.service.ClienteService;

@Controller
@RequestMapping(ClienteUrl.LISTA)
public class ClienteListaController extends ClienteController{
	
	@Autowired
	public ClienteListaController(ClienteService clienteService, CidadeService cidadeService) {
		super(clienteService, cidadeService);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		return new ModelAndView("cliente/listar", "clientes", this.clienteService.findAll());
	}
}
