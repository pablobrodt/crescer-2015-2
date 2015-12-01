package br.com.cwi.crescer.controller.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.controller.urlmapper.ClienteUrl;
import br.com.cwi.crescer.lavanderia.dto.ClienteResumoDTO;
import br.com.cwi.crescer.lavanderia.service.CidadeService;
import br.com.cwi.crescer.lavanderia.service.ClienteService;

@Controller
@RequestMapping(ClienteUrl.BUSCA)
public class ClienteBuscacontroller extends ClienteController{
	
	@Autowired
	public ClienteBuscacontroller(ClienteService clienteService, CidadeService cidadeService) {
		super(clienteService, cidadeService);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView buscarPorNome(@ModelAttribute("cliente") ClienteResumoDTO dto){
		
		List<ClienteResumoDTO> lista = clienteService.findByNeme(dto.getNome());
		
		return new ModelAndView("cliente/listar", "clientes", lista);
	}
	
}
