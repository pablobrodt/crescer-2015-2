package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.service.ItemService;

@Controller
public class ItemController {

	private ItemService is;
	
	@Autowired
	public ItemController(ItemService itemService){
		super();
		this.is = itemService;
	}
	
	@RequestMapping("/Item/")
	public String index(Model model){
		
		Item item = this.is.findById(1L);
		
		model.addAttribute("IDItem", item.getIdItem());
		model.addAttribute("Peso", item.getPeso());
		model.addAttribute("ValorUnitario", item.getValorUnitario());
		model.addAttribute("ValorDesconto", item.getValorDesconto());
		model.addAttribute("ValorTotal", item.getValorTotal());
		
		return "item/index";
	}
}
