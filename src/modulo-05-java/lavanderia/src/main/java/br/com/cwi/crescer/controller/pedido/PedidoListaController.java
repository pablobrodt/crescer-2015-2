package br.com.cwi.crescer.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.controller.urlmapper.PedidoUrl;
import br.com.cwi.crescer.exception.PedidoException;
import br.com.cwi.crescer.lavanderia.service.pedido.PedidoService;
@Controller
@RequestMapping(PedidoUrl.LISTA)
public class PedidoListaController extends PedidoController{
	
	@Autowired
	public PedidoListaController(PedidoService pedidoService) {
		super(pedidoService);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarTodos(final RedirectAttributes redirectAttributes){
		try {
			return new ModelAndView("pedido/listar", "pedidos", this.pedidoService.findAllResumed());
		} catch (PedidoException e) {
			redirectAttributes.addFlashAttribute("mensagem",e.getMensagem());
			return new ModelAndView("redirect:/");
		}
	}
	
}
