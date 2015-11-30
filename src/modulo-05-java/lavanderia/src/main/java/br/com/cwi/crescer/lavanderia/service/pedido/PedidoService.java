package br.com.cwi.crescer.lavanderia.service.pedido;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.PedidoDao;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.mapper.PedidoMapper;
import br.com.cwi.crescer.lavanderia.service.ClienteService;

@Service
public class PedidoService {
	
	private PedidoDao pedidoDao;
	private PedidoItemService pedidoItemService;
	private PedidoDescontoService pedidoDescontoService;
	private ClienteService clienteService;
	
	@Autowired
	public PedidoService(PedidoDao pedidoDao){
		this.pedidoDao = pedidoDao;
		this.pedidoItemService = new PedidoItemService();
		this.pedidoDescontoService = new PedidoDescontoService();
	}
	
	public Pedido findById(Long id){
		return this.pedidoDao.findById(id);
	}

	public void calcularValorBruto(Pedido entity){
		entity.setValorBruto(pedidoItemService.obterValorTotalDeItens(entity));
	}
	
	public void calcularValorDeDesconto(Pedido entity) throws Exception{
		if(entity.getValorBruto() != null){
			BigDecimal valorDesconto = new BigDecimal(0);
			BigDecimal multiplicadorDesconto = pedidoDescontoService.obterPercentualDeDesconto(entity).divide(new BigDecimal(100));
			
			valorDesconto = entity.getValorBruto().multiply(multiplicadorDesconto);
			valorDesconto = formatarEArredondar(valorDesconto);
			
			entity.setValorDesconto(valorDesconto);
		}else{
			throw new Exception("O valor bruto do pedido deve ser calculado antes do desconto.");
		}
	}
	
	public void calcularTotalPedido(Pedido entity) throws Exception{
		calcularValorBruto(entity);
		calcularValorDeDesconto(entity);
		entity.setValorFinal(entity.getValorBruto().subtract(entity.getValorDesconto()));
	}
	
	public PedidoDTO create(ClienteDTO clienteDto) throws Exception {
		PedidoDTO dto = new PedidoDTO();
		dto.setCliente(clienteDto);
		return save(dto);
	}
	
	public PedidoDTO save(PedidoDTO dto) throws Exception{
		dto.setDataInclusao(Calendar.getInstance().getTime());
		dto.setSituacao(SituacaoPedido.PENDENTE);
		Pedido entity = PedidoMapper.toEntity(dto);
		calcularTotalPedido(entity);
		return PedidoMapper.toDTO(this.pedidoDao.save(entity));
	}
	
	// TODO: Refatorar: A PedidoItemService poderia retornar o maior prazo dentre os itens 
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
	
	public void cancelarPedido(Long id){
		setSituacaoPedido(id, SituacaoPedido.CANCELADO);
	}
	
	public void retirarPedido(Long id) throws Exception{
		Pedido entity = findById(id);
		if(entity.getSituacao() == SituacaoPedido.PROCESSADO){
			setSituacaoPedido(id, SituacaoPedido.ENCERRADO);
		}else{
			throw new Exception("Somente pedidos já processados podem ser encerrados.");
		}
	}
	
	private void setSituacaoPedido(Long idPedido, SituacaoPedido situacao){
		Pedido entity = findById(idPedido);
		entity.setSituacao(situacao);
		
		pedidoDao.save(entity);
	}
	
	private BigDecimal formatarEArredondar(BigDecimal number){
		return number.setScale(2, BigDecimal.ROUND_DOWN);
	}
}
