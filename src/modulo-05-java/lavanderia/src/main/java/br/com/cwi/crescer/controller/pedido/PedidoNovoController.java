package br.com.cwi.crescer.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.controller.urlmapper.PedidoUrl;
import br.com.cwi.crescer.lavanderia.service.ClienteService;
import br.com.cwi.crescer.lavanderia.service.pedido.PedidoService;

@Controller
@RequestMapping(PedidoUrl.NOVO)
public class PedidoNovoController extends PedidoController{
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	public PedidoNovoController(PedidoService pedidoService) {
		super(pedidoService);
	}
	
	@RequestMapping(path = "/{idCliente}", method = RequestMethod.GET)
	public ModelAndView viewNovo(@PathVariable("idCliente") Long id){
		return new ModelAndView("pedido/novo", "cliente", this.clienteService.findById(id));
	}
	
}
