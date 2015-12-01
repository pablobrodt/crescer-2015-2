package br.com.cwi.crescer.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.controller.urlmapper.PedidoUrl;
import br.com.cwi.crescer.exception.PedidoException;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.service.pedido.PedidoService;

@Controller
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(PedidoUrl.CANCELAR)
public class PedidoCancelarController extends PedidoController{
	
	@Autowired
	public PedidoCancelarController(PedidoService pedidoService) {
		super(pedidoService);
	}

	@RequestMapping(path = "/{idPedido}", method = RequestMethod.GET)
	public ModelAndView viewCancelar(@PathVariable("idPedido") Long id,
									 final RedirectAttributes redirectAttributes){
		PedidoDTO dto;
		
		try {
			dto = pedidoService.findById(id);
		} catch (PedidoException e) {
			redirectAttributes.addFlashAttribute("mensagem", e.getMensagem());
			return new ModelAndView("redirect:"+PedidoUrl.LISTA);
		}
		
		return new ModelAndView("pedido/cancelar", "pedido", dto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView cancelar(@ModelAttribute("pedido") PedidoDTO dto,
								 RedirectAttributes redirectAttribute){
		try {
			pedidoService.cancelarPedido(dto.getIdPedido());
		} catch (PedidoException e) {
			redirectAttribute.addFlashAttribute("mensagem", e.getMensagem());
			return new ModelAndView("redirect:"+PedidoUrl.CANCELAR+"/"+dto.getIdPedido());
		}
		return new ModelAndView("redirect:"+PedidoUrl.LISTA);
	}
}
