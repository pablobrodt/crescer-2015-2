package br.com.cwi.crescer.lavanderia.service.pedido;

import static org.junit.Assert.assertEquals;

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

public class PedidoDescontoTest extends AbstractTest{

	@Autowired
	private PedidoDescontoService pedidoDescontoService;
	
	@Autowired
	private ItemService itemService;

	@Test
	public void pedidoFeitoEmSegundaFeiraTem8DeDesconto(){
		// Arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 10, 2);
		
		Produto produto1 = new Produto();
		produto1.setValor(new BigDecimal(10));
		
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
		
		BigDecimal descontoEsperado = new BigDecimal(8).setScale(2, BigDecimal.ROUND_DOWN);
		
		// Act 
		BigDecimal descontoObtido = pedidoDescontoService.obterPercentualDeDesconto(pedido);
		
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
		item1.setValorUnitario(new BigDecimal(100));
		
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
		BigDecimal descontoObtido = pedidoDescontoService.obterPercentualDeDesconto(pedido);
		
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
		item1.setValorUnitario(new BigDecimal(1));
		
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
		BigDecimal descontoObtido = pedidoDescontoService.obterPercentualDeDesconto(pedido);
		
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
		item1.setValorUnitario(new BigDecimal(100));
		
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
		BigDecimal descontoObtido = pedidoDescontoService.obterPercentualDeDesconto(pedido);
		
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
		item1.setValorUnitario(new BigDecimal(100));
		
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
		BigDecimal descontoObtido = pedidoDescontoService.obterPercentualDeDesconto(pedido);
		
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
		item1.setValorUnitario(new BigDecimal(100));
		
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
		BigDecimal descontoObtido = pedidoDescontoService.obterPercentualDeDesconto(pedido);
		
		// Assert
		assertEquals(descontoEsperado, descontoObtido);	
	}
	
}
