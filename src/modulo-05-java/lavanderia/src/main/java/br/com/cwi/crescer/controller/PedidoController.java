package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.cwi.crescer.lavanderia.service.PedidoService;

@Controller
public class PedidoController {
	
	private PedidoService ps;
	
	@Autowired
	public PedidoController(PedidoService pedidoService){
		super();
		this.ps = pedidoService;
	}
	
}
