package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.service.MaterialService;

@Controller
public class MaterialController {

	private MaterialService ms;
	
	@Autowired
	public MaterialController(MaterialService materialService){
		super();
		this.ms = materialService;
	}
	
	@RequestMapping("/Material/")
	public String index(Model model){
		
		Material material = this.ms.findById(1L);
		
		model.addAttribute("Descricao", material.getDescricao());
		
		return "material/index";
	}
	
}
