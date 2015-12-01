package br.com.cwi.crescer.lavanderia.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.exception.ItemException;
import br.com.cwi.crescer.exception.ItemJaProcessadoException;
import br.com.cwi.crescer.exception.PedidoException;
import br.com.cwi.crescer.lavanderia.dao.ItemDao;
import br.com.cwi.crescer.lavanderia.dao.PedidoDao;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.dto.ItemDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.dto.ProdutoDTO;
import br.com.cwi.crescer.lavanderia.mapper.ItemMapper;
import br.com.cwi.crescer.lavanderia.mapper.PedidoMapper;
import br.com.cwi.crescer.lavanderia.mapper.ProdutoMapper;
import br.com.cwi.crescer.lavanderia.service.pedido.PedidoService;

@Service
public class ItemService {
	
	private ItemDao itemDao;
	private ProdutoService produtoService;
	private PedidoService pedidoService;
	
	@Autowired
	public ItemService(ItemDao itemDao, ProdutoService produtoService, PedidoService pedidoService){
		this.itemDao = itemDao;
		this.produtoService = produtoService;
		this.pedidoService = pedidoService;
	}
	
	public Item findById(Long id){
		return this.itemDao.findById(id);
	}
	
	public void calcularValorTotalItem(Item entity){
		BigDecimal total = new BigDecimal(0);
		total = total.add(entity.getValorUnitario().multiply(entity.getPeso()).setScale(2, BigDecimal.ROUND_HALF_UP));
		
		entity.setValorTotal(total);
	}
	
	private void definirValorUnitarioItem(Item entity){
		entity.setValorUnitario(entity.getProduto().getValor());
	}
	
	@Transactional
	public ItemDTO save(ItemDTO dto) throws PedidoException {
		ProdutoDTO produto = ProdutoMapper.toDTO(produtoService.findById(dto.getProduto().getIdProduto()));
		dto.setProduto(produto);
		
		Pedido pedido = PedidoMapper.toEntity(pedidoService.findById(dto.getPedido()));
		
		Item entity = ItemMapper.toEntity(dto, pedido);
		
		definirValorUnitarioItem(entity);
		calcularValorTotalItem(entity);
		
		if(entity.getIdItem() == null){
			entity.tornarPendente();
		}
		
		return ItemMapper.toDTO(itemDao.save(entity), PedidoMapper.toDTO(pedido));
	}

	public void process(Long idItem) throws ItemException, PedidoException {
		Item item = itemDao.findById(idItem);
		if(item.getSituacao() == SituacaoItem.PENDENTE){
			item.setSituacao(SituacaoItem.PROCESSADO);
		}else{
			throw new ItemJaProcessadoException();
		}
		pedidoService.checkItens(item.getPedido().getIdPedido());
		itemDao.save(item);
	}

	public void processAll(Long idPedido) throws PedidoException, ItemException {
		PedidoDTO pedidoDTO = pedidoService.findById(idPedido);
		for (ItemDTO item : pedidoDTO.getItens()) {
			if(item.getSituacao() != SituacaoItem.PROCESSADO){
				process(item.getIdItem());
			}
		}
		pedidoService.processed(idPedido);
	}
}
