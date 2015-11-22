package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.service.PedidoService;

@Controller
public class PedidoController {
	
	private PedidoService ps;
	
	@Autowired
	public PedidoController(PedidoService pedidoService){
		super();
		this.ps = pedidoService;
	}
	
	@RequestMapping("/Pedido/")
	public String index(Model model){
		
		Pedido pedido = this.ps.findById(1L);
		
		model.addAttribute("IDPedido", pedido.getIdPedido());
		model.addAttribute("DataInclusao", pedido.getDataInclusao());
		model.addAttribute("DataEntrega", pedido.getDataEntrega());
		model.addAttribute("Valor", pedido.getValor());
		
		return "pedido/index";
	}
}
