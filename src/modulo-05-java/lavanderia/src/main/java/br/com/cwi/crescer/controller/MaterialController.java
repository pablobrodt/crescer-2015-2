package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.cwi.crescer.lavanderia.service.MaterialService;

@Controller
public class MaterialController {

	private MaterialService ms;
	
	@Autowired
	public MaterialController(MaterialService materialService){
		super();
		this.ms = materialService;
	}
	
}
