package br.com.cwi.crescer.lavanderia.service.pedido;

import java.math.BigDecimal;
import java.util.List;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Pedido;

class PedidoItemService {
	
	public BigDecimal obterValorTotalDeItens(Pedido entity) {
		BigDecimal total = new BigDecimal(0);
		
		for (Item item : entity.getItens()) {
			total = total.add(item.getValorTotal());
		}
		
		return total;
	}
	
	public BigDecimal obterPesoDosItensDoPedido(Pedido entity){
		BigDecimal peso = new BigDecimal(0);
		
		List<Item> itens = entity.getItens();
		
		for (Item item : itens) {
			peso = peso.add(item.getPeso());
		}
		
		return peso;
	}
	
}
