package br.com.cwi.crescer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;
import br.com.cwi.crescer.lavanderia.dto.UsuarioDTO;
import br.com.cwi.crescer.lavanderia.service.UsuarioService;

@Controller
@RequestMapping("/Usuarios")
public class UsuarioController {

	private UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService){
		this.usuarioService = usuarioService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		return new ModelAndView("usuario/listar", "usuarios", this.usuarioService.findAllEnabled());
	}
	
	@RequestMapping(path = "/Novo", method = RequestMethod.GET)
	public ModelAndView viewNovo(){
		return new ModelAndView("usuario/incluir", "usuario", new UsuarioDTO());
	}
	
	@RequestMapping(path = "/Novo", method = RequestMethod.POST)
	public ModelAndView incluir(@Valid @ModelAttribute("usuario") UsuarioDTO dto,
								BindingResult result,
								final RedirectAttributes redirectAttributes){
		
		redirectAttributes.addFlashAttribute("mensagem", "Inserido com sucesso!");
		
		if (result.hasErrors()) {
			return new ModelAndView("usuario/incluir");
		}

		this.usuarioService.insert(dto);
		return new ModelAndView("redirect:/Usuarios");
	}
}
