package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.cwi.crescer.lavanderia.service.ItemService;

@Controller
public class ItemController {

	private ItemService is;
	
	@Autowired
	public ItemController(ItemService itemService){
		super();
		this.is = itemService;
	}
	
}
