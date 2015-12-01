package br.com.cwi.crescer.controller.pedido;

import javax.servlet.http.HttpServletRequest;

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
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
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
	public ModelAndView viewNovo(HttpServletRequest request, 
								 @PathVariable("idCliente") Long id, 
								 final RedirectAttributes redirectAttributes){
		
		PedidoDTO dto;
		
		try {
			dto = this.pedidoService.create(this.clienteService.findById(id));
		} catch (PedidoException e) {
			redirectAttributes.addFlashAttribute(e.getMensagem());
			return new ModelAndView("redirect:"+ClienteUrl.LISTA);
		}
			
		return new ModelAndView("redirect:"+PedidoUrl.DETALHE+"/"+dto.getIdPedido());
	}
}