package br.com.cwi.crescer.lavanderia.service.pedido;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.PedidoDao;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.service.CalendarioService;

@Service
public class PedidoService {
	
	private PedidoDao pedidoDao;
	private PedidoItemService pedidoItemService;
	private PedidoDescontoService pedidoDescontoService;
	
	@Autowired
	public PedidoService(PedidoDao pedidoDao){
		this.pedidoDao = pedidoDao;
		this.pedidoItemService = new PedidoItemService();
		this.pedidoDescontoService = new PedidoDescontoService();
	}
	
	public Pedido findById(Long id){
		return this.pedidoDao.findById(id);
	}
	
	public BigDecimal obterValorTotalDeItens(Pedido entity) {
		return formatarEArredondar(pedidoItemService.obterValorTotalDeItens(entity));
	}
	
	public BigDecimal obterPesoDosItensDoPedido(Pedido entity){
		return formatarEArredondar(pedidoItemService.obterPesoDosItensDoPedido(entity));
	}
	
	public BigDecimal obterDesconto(Pedido entity){
		return formatarEArredondar(pedidoDescontoService.obterDesconto(entity));
	}
	
	public void calcularTotalPedido(Pedido entity){
		//TODO 
	}
	
	public void estimarEntregaPedido(Pedido entity){
		Long dias = 0L;
		for (Item item : entity.getItens()) {
			dias = item.getPrazo() > dias ? item.getPrazo() : dias;
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(entity.getDataInclusao());
		calendar.add(Calendar.DATE, dias.intValue());
		
		Date dataEstimada = calendar.getTime();
		
		entity.setDataEntrega(dataEstimada);
	}
	
	private BigDecimal formatarEArredondar(BigDecimal number){
		return number.setScale(2, BigDecimal.ROUND_DOWN);
	}
}
