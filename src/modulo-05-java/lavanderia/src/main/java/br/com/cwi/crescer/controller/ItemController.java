package br.com.cwi.crescer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.controller.urlmapper.ItemUrl;
import br.com.cwi.crescer.lavanderia.dto.ItemDTO;
import br.com.cwi.crescer.lavanderia.dto.MaterialDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.dto.ServicoDTO;
import br.com.cwi.crescer.lavanderia.service.ItemService;
import br.com.cwi.crescer.lavanderia.service.MaterialService;
import br.com.cwi.crescer.lavanderia.service.ServicoService;

@Controller
@RequestMapping(ItemUrl.BASE)
public class ItemController {

	private ItemService itemService;
	private ServicoService servicoService;
	private MaterialService materialService;
	
	private ArrayList<ItemDTO> itens;
	
	@Autowired
	public ItemController(ItemService itemService, ServicoService servicoService, MaterialService materialService){
		this.itemService = itemService;
		this.servicoService = servicoService;
		this.materialService = materialService;
		this.itens = new ArrayList<>();
	}
	
	@RequestMapping("/Novo")
	public ModelAndView viewNovo(){
		return new ModelAndView("item/novo", "item", new ItemDTO());
	}
	
	@RequestMapping(path = "/Novo", method = RequestMethod.POST)
	public ModelAndView adicionarItem(HttpServletRequest request, @ModelAttribute("item") ItemDTO dto){
		PedidoDTO pedido = (PedidoDTO)request.getSession().getAttribute("pedido");
		
		
		pedido.addItem(dto);
		return new ModelAndView("pedido/novo", "pedido", pedido);
	}
	
	@ModelAttribute("servicos")
    public List<ServicoDTO> comboServicos() {
        return servicoService.findAll();
    }
	
	@ModelAttribute("materiais")
    public List<MaterialDTO> comboMateriais() {
        return materialService.findAll();
    }
}
