package br.com.cwi.crescer.lavanderia.service.pedido;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractTest;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.service.ItemService;

public class PedidoServiceTest extends AbstractTest {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private PedidoItemService pedidoItemService;
	
	@Autowired
	private PedidoDescontoService pedidoDescontoService;
	
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
	public void pedidoDe100FeitoEmSegundaFeiraTemValor8DeDesconto() throws Exception{
		// Arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 10, 2);
		
		Produto produto1 = new Produto();
		produto1.setValor(new BigDecimal(100));
		
		Item item1 = new Item(produto1);
		item1.setPeso(new BigDecimal(1));
		item1.setValorUnitario(new BigDecimal(100));
		
		ArrayList<Item> itens = new ArrayList<>();
		itens.add(item1);
		
		for (Item item : itens) {
			itemService.calcularValorTotalItem(item);
		}
		
		Pedido pedido = new Pedido();
		pedido.setItens(itens);
		pedido.setDataInclusao(calendar.getTime());
		pedido.setValorBruto(new BigDecimal(100));
		
		BigDecimal descontoEsperado = new BigDecimal(8).setScale(2, BigDecimal.ROUND_DOWN);
		
		// Act 
		pedidoService.calcularValorDeDesconto(pedido);
		BigDecimal descontoObtido = pedido.getValorDesconto();
		
		// Assert
		assertEquals(descontoEsperado, descontoObtido);	
	}
	
	@Test
	public void pedidoDeTotal200FeitoEmSegundaFeiraTemValorFinal184() throws Exception{
		// Arrange
				Calendar calendar = Calendar.getInstance();
				calendar.set(2015, 10, 2);
				
				Produto produto1 = new Produto();
				produto1.setValor(new BigDecimal(100));
				
				Item item1 = new Item(produto1);
				item1.setPeso(new BigDecimal(2));
				item1.setValorUnitario(new BigDecimal(100));
				
				ArrayList<Item> itens = new ArrayList<>();
				itens.add(item1);
				
				for (Item item : itens) {
					itemService.calcularValorTotalItem(item);
				}
				
				Pedido pedido = new Pedido();
				pedido.setItens(itens);
				pedido.setDataInclusao(calendar.getTime());
				
				BigDecimal valorEsperado = new BigDecimal(184).setScale(2, BigDecimal.ROUND_DOWN);
				
				// Act 
				pedidoService.calcularTotalPedido(pedido);
				BigDecimal valorObtido = pedido.getValorFinal();
				
				// Assert
				assertEquals(valorEsperado, valorObtido);	
	}
}
