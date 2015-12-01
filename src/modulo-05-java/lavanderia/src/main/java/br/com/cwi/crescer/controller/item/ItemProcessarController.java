package br.com.cwi.crescer.controller.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.controller.urlmapper.ItemUrl;
import br.com.cwi.crescer.controller.urlmapper.PedidoUrl;
import br.com.cwi.crescer.exception.AbstractException;
import br.com.cwi.crescer.exception.ItemException;
import br.com.cwi.crescer.lavanderia.service.ItemService;
import br.com.cwi.crescer.lavanderia.service.MaterialService;
import br.com.cwi.crescer.lavanderia.service.ServicoService;
import br.com.cwi.crescer.lavanderia.service.pedido.PedidoService;

@Controller
@RequestMapping(ItemUrl.PROCESSAR)
public class ItemProcessarController extends ItemController{
	
	@Autowired
	public ItemProcessarController(ItemService itemService, ServicoService servicoService,
			MaterialService materialService, PedidoService pedidoService) {
		super(itemService, servicoService, materialService, pedidoService);
	}
	
	@RequestMapping(path = "/{idPedido}/{idItem}", method = RequestMethod.GET)
	public ModelAndView processar(@PathVariable("idItem") Long idItem,
								  @PathVariable("idPedido") Long idPedido,
			 					  final RedirectAttributes redirectAttributes){
		try {
			itemService.process(idItem);
		} catch (AbstractException e) {
			redirectAttributes.addFlashAttribute("mensagem", e.getMensagem());
		}
		return new ModelAndView("redirect:"+PedidoUrl.DETALHE+"/"+idPedido);
	}
	
	@RequestMapping(path = "/{idPedido}", method = RequestMethod.GET)
	public ModelAndView processar(@PathVariable("idPedido") Long idPedido,
			 					  final RedirectAttributes redirectAttributes){
		try {
			itemService.processAll(idPedido);
		} catch (AbstractException e) {
			redirectAttributes.addFlashAttribute("mensagem", e.getMensagem());
		}
		return new ModelAndView("redirect:"+PedidoUrl.DETALHE+"/"+idPedido);
	}

}
