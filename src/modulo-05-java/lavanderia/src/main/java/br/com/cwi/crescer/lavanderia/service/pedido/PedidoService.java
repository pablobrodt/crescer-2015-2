package br.com.cwi.crescer.lavanderia.service.pedido;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.exception.PedidoDescontoException;
import br.com.cwi.crescer.exception.PedidoException;
import br.com.cwi.crescer.exception.PedidoJaProcessadoException;
import br.com.cwi.crescer.exception.ProcessoJaIniciadoException;
import br.com.cwi.crescer.lavanderia.dao.PedidoDao;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoResumoDTO;
import br.com.cwi.crescer.lavanderia.mapper.PedidoMapper;

@Service
public class PedidoService {
	
	protected PedidoDao pedidoDao;
	private PedidoItemService pedidoItemService;
	private PedidoDescontoService pedidoDescontoService;
	
	@Autowired
	public PedidoService(PedidoDao pedidoDao){
		this.pedidoDao = pedidoDao;
		this.pedidoItemService = new PedidoItemService();
		this.pedidoDescontoService = new PedidoDescontoService();
	}
	
	public PedidoDTO findById(Long id) throws PedidoException{
		Pedido entity = this.pedidoDao.findById(id);
		calcularTotalPedido(entity);
		return PedidoMapper.toDTO(entity);
	}

	public List<PedidoResumoDTO> findAllResumed() throws PedidoException {
		List<Pedido> pedidos = this.pedidoDao.findAll();
		calcularTotalListaPedidos(pedidos);
		return PedidoMapper.toResumoDTOList(pedidos);
	}
	
	public void calcularValorBruto(Pedido entity){
		entity.setValorBruto(pedidoItemService.obterValorTotalDeItens(entity));
	}
	
	public void calcularValorDeDesconto(Pedido entity) throws PedidoException{
		if(entity.getValorBruto() != null){
			BigDecimal valorDesconto = new BigDecimal(0);
			BigDecimal multiplicadorDesconto = pedidoDescontoService.obterPercentualDeDesconto(entity).divide(new BigDecimal(100));
			
			valorDesconto = entity.getValorBruto().multiply(multiplicadorDesconto);
			valorDesconto = formatarEArredondar(valorDesconto);
			
			entity.setValorDesconto(valorDesconto);
		}else{
			throw new PedidoDescontoException();
		}
	}
	
	public void calcularTotalPedido(Pedido entity) throws PedidoException{
		calcularValorBruto(entity);
		calcularValorDeDesconto(entity);
		entity.setValorFinal(entity.getValorBruto().subtract(entity.getValorDesconto()));
	}
	
	public void calcularTotalListaPedidos(List<Pedido> entityList) throws PedidoException{
		for (Pedido pedido : entityList) {
			calcularTotalPedido(pedido);
		}
	}
	
	public void calcularTotalPedido(PedidoDTO dto) throws PedidoException{
		Pedido entity = PedidoMapper.toEntity(dto);
		calcularTotalPedido(entity);
		dto.setValorBruto(entity.getValorBruto());
		dto.setValorDesconto(entity.getValorDesconto());
		dto.setValorFinal(entity.getValorFinal());
	}
	
	public PedidoDTO create(ClienteDTO clienteDto) throws PedidoException {
		PedidoDTO dto = new PedidoDTO();
		dto.setCliente(clienteDto);
		return save(dto);
	}
	
	public PedidoDTO save(PedidoDTO dto) throws PedidoException{
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
	
	public void cancelarPedido(Long id) throws PedidoException{
		setSituacaoPedido(id, SituacaoPedido.CANCELADO);
	}
	
	public void retirarPedido(Long id) throws Exception{
		Pedido entity = PedidoMapper.toEntity(findById(id));
		if(entity.getSituacao() == SituacaoPedido.PROCESSADO){
			setSituacaoPedido(id, SituacaoPedido.ENCERRADO);
		}else{
			throw new Exception("Somente pedidos já processados podem ser encerrados.");
		}
	}
	
	private void setSituacaoPedido(Long idPedido, SituacaoPedido situacao) throws PedidoException{
		Pedido entity = PedidoMapper.toEntity(findById(idPedido));
		entity.setSituacao(situacao);
		
		pedidoDao.save(entity);
	}
	
	private BigDecimal formatarEArredondar(BigDecimal number){
		return number.setScale(2, BigDecimal.ROUND_DOWN);
	}

	public void process(Long idPedido) throws PedidoException {
		Pedido entity = pedidoDao.findById(idPedido);
		if(entity.getSituacao() == SituacaoPedido.PENDENTE){
			setSituacaoPedido(idPedido, SituacaoPedido.PROCESSANDO);
		}else{
			throw new ProcessoJaIniciadoException();
		}
	}
	
	public void checkItens(Long idPedido) throws PedidoException{
		Pedido entity = pedidoDao.findById(idPedido);
		boolean itensProcessados = false;
		for (Item item : entity.getItens()) {
			itensProcessados = item.getSituacao() == SituacaoItem.PROCESSADO;
		}
		if(itensProcessados){
			processed(idPedido);
		}
	}
	
	public void processed(Long idPedido) throws PedidoException {
		Pedido entity = pedidoDao.findById(idPedido);
		if(entity.getSituacao() == SituacaoPedido.PROCESSANDO){
			setSituacaoPedido(idPedido, SituacaoPedido.PROCESSADO);
		}else{
			throw new PedidoJaProcessadoException();
		}
	}
}
