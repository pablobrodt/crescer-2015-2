package br.com.cwi.crescer.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.controller.urlmapper.PedidoUrl;
import br.com.cwi.crescer.exception.AbstractException;
import br.com.cwi.crescer.exception.PedidoException;
import br.com.cwi.crescer.exception.SomenteProdutosProcessadosPodemSerCanceladosException;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.service.pedido.PedidoService;

@Controller
@RequestMapping(PedidoUrl.ENCERRAR)
public class PedidoEncerrarController extends PedidoController{

	@Autowired
	public PedidoEncerrarController(PedidoService pedidoService) {
		super(pedidoService);
	}
	
	@RequestMapping(path = "/{idPedido}", method = RequestMethod.GET)
	public ModelAndView viewCancelar(@PathVariable("idPedido") Long id,
									 final RedirectAttributes redirectAttributes){
		PedidoDTO dto;
		
		try {
			dto = pedidoService.findById(id);
			verificaSituacaoPedido(dto);
		} catch (PedidoException e) {
			redirectAttributes.addFlashAttribute("mensagem", e.getMensagem());
			return new ModelAndView("redirect:"+PedidoUrl.LISTA);
		}
		
		return new ModelAndView("pedido/encerrar", "pedido", dto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView cancelar(@ModelAttribute("pedido") PedidoDTO dto,
								 RedirectAttributes redirectAttribute){
		
		
		try {
			dto = pedidoService.findById(dto.getIdPedido());
			verificaSituacaoPedido(dto);
			pedidoService.encerrarPedido(dto.getIdPedido());
		} catch (PedidoException e) {
			redirectAttribute.addFlashAttribute("mensagem", e.getMensagem());
			return new ModelAndView("redirect:"+PedidoUrl.ENCERRAR+"/"+dto.getIdPedido());
		}
		return new ModelAndView("redirect:"+PedidoUrl.LISTA);
	}
	
	private void verificaSituacaoPedido(PedidoDTO dto) throws SomenteProdutosProcessadosPodemSerCanceladosException{
		if(dto.getSituacao() != SituacaoPedido.PROCESSADO){
			throw new SomenteProdutosProcessadosPodemSerCanceladosException();
		}
	}
	
}
