package br.com.cwi.crescer.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.controller.urlmapper.ClienteUrl;
import br.com.cwi.crescer.controller.urlmapper.PedidoUrl;
import br.com.cwi.crescer.exception.PedidoException;
import br.com.cwi.crescer.lavanderia.service.pedido.PedidoService;

@Controller
@RequestMapping(PedidoUrl.DETALHE)
public class PedidoDetalheController extends PedidoController{

	@Autowired
	public PedidoDetalheController(PedidoService pedidoService) {
		super(pedidoService);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView exibe(@PathVariable("id") Long id, 
							  final RedirectAttributes redirectAttributes){
		try {
			return new ModelAndView("pedido/detalhe", "pedido", this.pedidoService.findById(id));
		} catch (PedidoException e) {
			redirectAttributes.addFlashAttribute(e.getMensagem());
			return new ModelAndView("redirect:"+PedidoUrl.DETALHE+"/"+id);
		}
	}
}
