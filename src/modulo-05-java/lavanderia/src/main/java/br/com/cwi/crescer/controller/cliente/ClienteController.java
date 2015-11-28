package br.com.cwi.crescer.controller.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.controller.urlmapper.ClienteUrl;
import br.com.cwi.crescer.lavanderia.dto.CidadeDTO;
import br.com.cwi.crescer.lavanderia.mapper.CidadeMapper;
import br.com.cwi.crescer.lavanderia.service.CidadeService;
import br.com.cwi.crescer.lavanderia.service.ClienteService;

@Controller
@RequestMapping(ClienteUrl.BASE)
public class ClienteController {
	
	protected ClienteService clienteService;
	protected CidadeService cidadeService;
	
	@Autowired
	public ClienteController(ClienteService clienteService, CidadeService cidadeService){
		this.clienteService = clienteService;
		this.cidadeService = cidadeService;
	}
	
	@ModelAttribute("cidades")
    public List<CidadeDTO> comboCidades() {
        return CidadeMapper.toDtoList(cidadeService.findAll());
    }
}
