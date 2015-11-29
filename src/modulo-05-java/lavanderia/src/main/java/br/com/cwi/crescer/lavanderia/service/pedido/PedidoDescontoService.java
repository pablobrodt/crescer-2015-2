package br.com.cwi.crescer.lavanderia.service.pedido;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.service.CalendarioService;

@Service
public class PedidoDescontoService {
	
	private PedidoItemService pedidoItemServices = new PedidoItemService();
	private CalendarioService calendarioService = new CalendarioService();
	
	private final BigDecimal descontoPorPesoValor = new BigDecimal(4.87).setScale(2, BigDecimal.ROUND_DOWN);
	private final BigDecimal descontoSegundaAQuarta = new BigDecimal(8).setScale(2, BigDecimal.ROUND_DOWN);
	private final BigDecimal descontoQuintaOuSexta = new BigDecimal(4).setScale(2, BigDecimal.ROUND_DOWN);
	
	public BigDecimal obterPercentualDeDesconto(Pedido entity){
		BigDecimal desconto = new BigDecimal(0);
		
		Date dataInclusao = entity.getDataInclusao();
		
		BigDecimal pesoTotalDosItens = pedidoItemServices.obterPesoDosItensDoPedido(entity);
		BigDecimal valorTotalDosItens = pedidoItemServices.obterValorTotalDeItens(entity);
		
		if(descontoPorPesoOuValor(pesoTotalDosItens, valorTotalDosItens)){
			desconto = desconto.compareTo(descontoPorPesoValor) < 0 ? descontoPorPesoValor : desconto;
		}

		if(calendarioService.diaEhSegundaAQuarta(dataInclusao)){
			desconto = desconto.compareTo(descontoSegundaAQuarta) < 0 ? descontoSegundaAQuarta : desconto;
		}
		
		if (calendarioService.diaEhQuintaOuSexta(dataInclusao)){
			desconto = desconto.compareTo(descontoQuintaOuSexta) < 0 ? descontoQuintaOuSexta : desconto;
		}
		
		return desconto;
	}
	
	private boolean descontoPorPesoOuValor(BigDecimal peso, BigDecimal valor){
		BigDecimal pesoAceito = new BigDecimal(15);
		BigDecimal valorAceito = new BigDecimal(90);
		
		return peso.compareTo(pesoAceito) > 0 || valor.compareTo(valorAceito) > 0;
	}
}
