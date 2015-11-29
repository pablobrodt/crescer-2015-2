package br.com.cwi.crescer.lavanderia.service.pedido;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractTest;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.service.ItemService;

public class PedidoItemServiceTest extends AbstractTest{

	@Autowired
	private PedidoItemService pedidoItemService;
	
	@Autowired
	private ItemService itemService;
	
	@Test
	public void valorTotalDeItensDoPedidoDeveSer21(){
		// Arrange
		Produto produto1 = new Produto();
		produto1.setValor(new BigDecimal(7));
		
		Produto produto2 = new Produto();
		produto2.setValor(new BigDecimal(7));
		
		Produto produto3 = new Produto();
		produto3.setValor(new BigDecimal(7));
		
		Item item1 = new Item(produto1);
		item1.setPeso(new BigDecimal(1));
		
		Item item2 = new Item(produto2);
		item2.setPeso(new BigDecimal(1));
		
		Item item3 = new Item(produto3);
		item3.setPeso(new BigDecimal(1));
		
		ArrayList<Item> itens = new ArrayList<>();
		itens.add(item1);
		itens.add(item2);
		itens.add(item3);
		
		for (Item item : itens) {
			itemService.calcularValorTotalItem(item);
		}
		
		Pedido pedido = new Pedido();
		pedido.setItens(itens);
		
		BigDecimal totalEsperado = new BigDecimal(21).setScale(2, BigDecimal.ROUND_DOWN);
		
		// Act 
		BigDecimal totalObtido = pedidoItemService.obterValorTotalDeItens(pedido).setScale(2, BigDecimal.ROUND_DOWN);
		
		// Assert
		assertEquals(totalEsperado, totalObtido);
	}
	
	@Test
	public void valorTotalDeItensDoPedidoDeveSer123V12(){
		// Arrange
		Produto produto1 = new Produto();
		produto1.setValor(new BigDecimal(50));
		
		Produto produto2 = new Produto();
		produto2.setValor(new BigDecimal(5));
		
		Produto produto3 = new Produto();
		produto3.setValor(new BigDecimal(3.12));
		
		Item item1 = new Item(produto1);
		item1.setPeso(new BigDecimal(2));
		
		Item item2 = new Item(produto2);
		item2.setPeso(new BigDecimal(4));
		
		Item item3 = new Item(produto3);
		item3.setPeso(new BigDecimal(1));
		
		ArrayList<Item> itens = new ArrayList<>();
		itens.add(item1);
		itens.add(item2);
		itens.add(item3);
		
		for (Item item : itens) {
			itemService.calcularValorTotalItem(item);
		}
		
		Pedido pedido = new Pedido();
		pedido.setItens(itens);
		
		BigDecimal totalEsperado = new BigDecimal(123.12).setScale(2, BigDecimal.ROUND_DOWN);
		
		// Act 
		BigDecimal totalObtido = pedidoItemService.obterValorTotalDeItens(pedido).setScale(2, BigDecimal.ROUND_DOWN);
		
		// Assert
		assertEquals(totalEsperado, totalObtido);
	}

	@Test
	public void pesoDoPedidoDeveSer100(){
		// Arrange
		Item item1 = new Item();
		item1.setPeso(new BigDecimal(45));
		
		Item item2 = new Item();
		item2.setPeso(new BigDecimal(55));
		
		ArrayList<Item> itens = new ArrayList<>();
		itens.add(item1);
		itens.add(item2);
		
		Pedido pedido = new Pedido();
		pedido.setItens(itens);
		
		BigDecimal totalEsperado = new BigDecimal(100).setScale(2, BigDecimal.ROUND_DOWN);
		
		// Act 
		BigDecimal totalObtido = pedidoItemService.obterPesoDosItensDoPedido(pedido).setScale(2, BigDecimal.ROUND_DOWN);
		
		// Assert
		assertEquals(totalEsperado, totalObtido);
	}
	
	@Test
	public void pesoDoPedidoDeveSer85V31(){
		// Arrange
		Item item1 = new Item();
		item1.setPeso(new BigDecimal(42));
		
		Item item2 = new Item();
		item2.setPeso(new BigDecimal(43.31));
		
		ArrayList<Item> itens = new ArrayList<>();
		itens.add(item1);
		itens.add(item2);
		
		Pedido pedido = new Pedido();
		pedido.setItens(itens);
		
		BigDecimal totalEsperado = new BigDecimal(85.31).setScale(2, BigDecimal.ROUND_DOWN);
		
		// Act 
		BigDecimal totalObtido = pedidoItemService.obterPesoDosItensDoPedido(pedido).setScale(2, BigDecimal.ROUND_DOWN);
		
		// Assert
		assertEquals(totalEsperado, totalObtido);
	}
}
