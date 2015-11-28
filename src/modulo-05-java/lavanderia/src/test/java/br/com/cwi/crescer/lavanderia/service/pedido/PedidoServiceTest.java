package br.com.cwi.crescer.lavanderia.service.pedido;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.service.ItemService;
import br.com.cwi.crescer.lavanderia.service.pedido.PedidoService;

public class PedidoServiceTest extends AbstractInfrastructureTest {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ItemService itemService;
	
	@Test
	public void dataEstimadaDeveSer29112015(){
		// Arrange
		Produto produto = new Produto();
		produto.setPrazo(1L);
		
		Item item = new Item();
		item.setProduto(produto);
		
		ArrayList<Item> itens = new ArrayList<>();
		itens.add(item);
		
		Calendar c = Calendar.getInstance();
		
		c.set(2015, 11, 24);
		
		Pedido pedido = new Pedido();
		pedido.setItens(itens);
		pedido.setDataInclusao(c.getTime());
		
		Calendar esperado = Calendar.getInstance();
		esperado.set(2015, 11, 25);
		
		// Act 
		pedidoService.estimarEntregaPedido(pedido);
		
		// Assert
		assertTrue(esperado.getTime().compareTo(pedido.getDataEntrega()) == 0);
	}
	
	
	@Test
	public void dataEstimadaDeveSer01012016(){
		// Arrange
		Produto produto = new Produto();
		produto.setPrazo(1L);
		
		Item item = new Item();
		item.setProduto(produto);
		
		ArrayList<Item> itens = new ArrayList<>();
		itens.add(item);
		
		Calendar c = Calendar.getInstance();
		
		c.set(2015, 11, 31);
		
		Pedido pedido = new Pedido();
		pedido.setItens(itens);
		pedido.setDataInclusao(c.getTime());
		
		Calendar esperado = Calendar.getInstance();
		esperado.set(2016, 0, 1);
		
		// Act 
		pedidoService.estimarEntregaPedido(pedido);
		
		// Assert
		assertTrue(esperado.getTime().compareTo(pedido.getDataEntrega()) == 0);
	}
	
	
	@Test
	public void dataEstimadaDeveSer10102015(){
		// Arrange
		Produto produto1 = new Produto();
		produto1.setPrazo(1L);
		
		Produto produto2 = new Produto();
		produto2.setPrazo(5L);
		
		Produto produto3 = new Produto();
		produto3.setPrazo(2L);
		
		Item item1 = new Item();
		item1.setProduto(produto1);
		
		Item item2 = new Item();
		item2.setProduto(produto2);
		
		Item item3 = new Item();
		item3.setProduto(produto3);
		
		ArrayList<Item> itens = new ArrayList<>();
		itens.add(item1);
		itens.add(item2);
		itens.add(item3);
		
		Calendar c = Calendar.getInstance();
		
		c.set(2015, 9, 5);
		
		Pedido pedido = new Pedido();
		pedido.setItens(itens);
		pedido.setDataInclusao(c.getTime());
		
		Calendar esperado = Calendar.getInstance();
		esperado.set(2015, 9, 10);
		
		// Act 
		pedidoService.estimarEntregaPedido(pedido);
		
		// Assert
		assertTrue(esperado.getTime().compareTo(pedido.getDataEntrega()) == 0);
	}
	
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
		BigDecimal totalObtido = pedidoService.obterValorTotalDeItens(pedido);
		
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
		BigDecimal totalObtido = pedidoService.obterValorTotalDeItens(pedido);
		
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
		BigDecimal totalObtido = pedidoService.obterPesoDosItensDoPedido(pedido);
		
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
		BigDecimal totalObtido = pedidoService.obterPesoDosItensDoPedido(pedido).setScale(2, BigDecimal.ROUND_DOWN);
		
		// Assert
		assertEquals(totalEsperado, totalObtido);
	}
	
	@Test
	public void pedidoFeitoEmSegundaFeiraTem8DeDesconto(){
		// Arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 10, 2);
		
		Produto produto1 = new Produto();
		produto1.setValor(new BigDecimal(10));
		
		Item item1 = new Item(produto1);
		item1.setPeso(new BigDecimal(2));
		
		ArrayList<Item> itens = new ArrayList<>();
		itens.add(item1);
		
		for (Item item : itens) {
			itemService.calcularValorTotalItem(item);
		}
		
		Pedido pedido = new Pedido();
		pedido.setItens(itens);
		pedido.setDataInclusao(calendar.getTime());
		
		BigDecimal descontoEsperado = new BigDecimal(8).setScale(2, BigDecimal.ROUND_DOWN);
		
		// Act 
		BigDecimal descontoObtido = pedidoService.obterDesconto(pedido);
		
		// Assert
		assertEquals(descontoEsperado, descontoObtido);
	}
	
	@Test
	public void pedidoFeitoEmTerçaFeiraTem8DeDesconto(){
		// Arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 10, 3);
		
		Produto produto1 = new Produto();
		produto1.setValor(new BigDecimal(20));
		
		Item item1 = new Item(produto1);
		item1.setPeso(new BigDecimal(2));
		
		ArrayList<Item> itens = new ArrayList<>();
		itens.add(item1);
		
		for (Item item : itens) {
			itemService.calcularValorTotalItem(item);
		}
		
		Pedido pedido = new Pedido();
		pedido.setItens(itens);
		pedido.setDataInclusao(calendar.getTime());
		
		BigDecimal descontoEsperado = new BigDecimal(8).setScale(2, BigDecimal.ROUND_DOWN);
		
		// Act 
		BigDecimal descontoObtido = pedidoService.obterDesconto(pedido);
		
		// Assert
		assertEquals(descontoEsperado, descontoObtido);		
	}
	
	@Test
	public void pedidoFeitoEmQuintaFeiraTem4DeDesconto(){
		// Arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 10, 26);
		
		Produto produto1 = new Produto();
		produto1.setValor(new BigDecimal(20));
		
		Item item1 = new Item(produto1);
		item1.setPeso(new BigDecimal(2));
		
		ArrayList<Item> itens = new ArrayList<>();
		itens.add(item1);
		
		for (Item item : itens) {
			itemService.calcularValorTotalItem(item);
		}
		
		Pedido pedido = new Pedido();
		pedido.setItens(itens);
		pedido.setDataInclusao(calendar.getTime());
		
		BigDecimal descontoEsperado = new BigDecimal(4).setScale(2, BigDecimal.ROUND_DOWN);
		
		// Act 
		BigDecimal descontoObtido = pedidoService.obterDesconto(pedido);
		
		// Assert
		assertEquals(descontoEsperado, descontoObtido);		
	}
	
	@Test
	public void pedidoCom16KgTem4V87DeDesconto(){
		// Arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 10, 26);
		
		Produto produto1 = new Produto();
		produto1.setValor(new BigDecimal(20));
		
		Item item1 = new Item(produto1);
		item1.setPeso(new BigDecimal(16));
		
		ArrayList<Item> itens = new ArrayList<>();
		itens.add(item1);
		
		for (Item item : itens) {
			itemService.calcularValorTotalItem(item);
		}
		
		Pedido pedido = new Pedido();
		pedido.setItens(itens);
		pedido.setDataInclusao(calendar.getTime());
		
		BigDecimal descontoEsperado = new BigDecimal(4.87).setScale(2, BigDecimal.ROUND_DOWN);
		
		// Act 
		BigDecimal descontoObtido = pedidoService.obterDesconto(pedido);
		
		// Assert
		assertEquals(descontoEsperado, descontoObtido);		
	}
	
	@Test
	public void pedidoComTotal200Tem4V87DeDesconto(){
		// Arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 10, 26);
		
		Produto produto1 = new Produto();
		produto1.setValor(new BigDecimal(100));
		
		Item item1 = new Item(produto1);
		item1.setPeso(new BigDecimal(2));
		
		ArrayList<Item> itens = new ArrayList<>();
		itens.add(item1);
		
		for (Item item : itens) {
			itemService.calcularValorTotalItem(item);
		}
		
		Pedido pedido = new Pedido();
		pedido.setItens(itens);
		pedido.setDataInclusao(calendar.getTime());
		
		BigDecimal descontoEsperado = new BigDecimal(4.87).setScale(2, BigDecimal.ROUND_DOWN);
		
		// Act 
		BigDecimal descontoObtido = pedidoService.obterDesconto(pedido);
		
		// Assert
		assertEquals(descontoEsperado, descontoObtido);		
	}
	
	@Test
	public void pedidoComTotal200FeitoEmSegundaFeiraTem8DeDesconto(){
		// Arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 10, 2);
		
		Produto produto1 = new Produto();
		produto1.setValor(new BigDecimal(100));
		
		Item item1 = new Item(produto1);
		item1.setPeso(new BigDecimal(2));
		
		ArrayList<Item> itens = new ArrayList<>();
		itens.add(item1);
		
		for (Item item : itens) {
			itemService.calcularValorTotalItem(item);
		}
		
		Pedido pedido = new Pedido();
		pedido.setItens(itens);
		pedido.setDataInclusao(calendar.getTime());
		
		BigDecimal descontoEsperado = new BigDecimal(8).setScale(2, BigDecimal.ROUND_DOWN);
		
		// Act 
		BigDecimal descontoObtido = pedidoService.obterDesconto(pedido);
		
		// Assert
		assertEquals(descontoEsperado, descontoObtido);	
	}
}
