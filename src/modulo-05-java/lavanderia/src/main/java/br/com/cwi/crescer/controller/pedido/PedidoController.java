package br.com.cwi.crescer.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.controller.urlmapper.PedidoUrl;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.service.pedido.PedidoService;

@Controller
@RequestMapping(PedidoUrl.BASE)
public class PedidoController {
	
	protected PedidoService pedidoService;
	
	@Autowired
	public PedidoController(PedidoService pedidoService){
		this.pedidoService = pedidoService;
	}
}
