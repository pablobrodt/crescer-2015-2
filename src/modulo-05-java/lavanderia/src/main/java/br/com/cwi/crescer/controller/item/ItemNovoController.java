package br.com.cwi.crescer.controller.item;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.controller.urlmapper.ItemUrl;
import br.com.cwi.crescer.controller.urlmapper.PedidoUrl;
import br.com.cwi.crescer.exception.PedidoException;
import br.com.cwi.crescer.lavanderia.dto.ItemDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.service.ItemService;
import br.com.cwi.crescer.lavanderia.service.MaterialService;
import br.com.cwi.crescer.lavanderia.service.ServicoService;
import br.com.cwi.crescer.lavanderia.service.pedido.PedidoService;

@Controller
@RequestMapping(ItemUrl.NOVO)
public class ItemNovoController extends ItemController{
	
	@Autowired
	public ItemNovoController(ItemService itemService, ServicoService servicoService, MaterialService materialService,
			PedidoService pedidoService) {
		super(itemService, servicoService, materialService, pedidoService);
	}
	
	@RequestMapping(path = "/{idPedido}")
	public ModelAndView viewNovo(@PathVariable("idPedido") Long idPedido,
								 final RedirectAttributes redirectAttributes){
		
		PedidoDTO pedido;
		try {
			pedido = pedidoService.findById(idPedido);
		} catch (PedidoException e) {
			redirectAttributes.addFlashAttribute("mensagem", e.getMensagem());	
			return new ModelAndView("redirect:"+PedidoUrl.DETALHE+"/"+idPedido);
		}
		
		if(pedido.isPendente()){
			ItemDTO dto = new ItemDTO();
			dto.setPedido(idPedido);
			return new ModelAndView("item/novo", "item", dto);
		}else{
			redirectAttributes.addFlashAttribute("mensagem", 
			"Não é possível adicionar itens à um pedido que esteja "+pedido.getSituacao());	
			
			return new ModelAndView("redirect:"+PedidoUrl.DETALHE+"/"+idPedido);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView adicionarItem(@Valid @ModelAttribute("item") ItemDTO dto,
									  BindingResult result,
									  final RedirectAttributes redirectAttributes){
		
		if (result.hasErrors()) {
			return new ModelAndView("item/novo");
		}
		
		try {
			dto = itemService.save(dto);
		} catch (PedidoException e) {
			redirectAttributes.addFlashAttribute("mensagem", e.getMensagem());
		}
		
		return new ModelAndView("redirect:"+PedidoUrl.DETALHE+"/"+ dto.getPedido());
	}

}
