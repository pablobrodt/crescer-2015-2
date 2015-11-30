package br.com.cwi.crescer.controller.pedido;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.controller.urlmapper.PedidoUrl;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;
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
		
		if(sessionTemPedido(request)){
			dto = (PedidoDTO)request.getSession().getAttribute("pedido");
		}else{
			try {
				dto = this.pedidoService.create(this.clienteService.findById(id));
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute(e.getMessage());
				e.printStackTrace();
				return new ModelAndView("redirect:/Clientes/Listar");
			}
			
			request.getSession().setAttribute("pedido", dto);
		}
		
		return new ModelAndView("pedido/novo", "pedido", dto);
	}
	
	private boolean sessionTemPedido(HttpServletRequest request){
		return request.getSession().getAttribute("pedido") != null;
	}
}
