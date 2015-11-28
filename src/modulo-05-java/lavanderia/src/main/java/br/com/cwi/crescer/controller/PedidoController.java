package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.controller.urlmapper.PedidoUrl;
import br.com.cwi.crescer.lavanderia.service.pedido.PedidoService;

@Controller
@RequestMapping(PedidoUrl.BASE)
public class PedidoController {
	
	private PedidoService ps;
	
	@Autowired
	public PedidoController(PedidoService pedidoService){
		this.ps = pedidoService;
	}
	
	

}
