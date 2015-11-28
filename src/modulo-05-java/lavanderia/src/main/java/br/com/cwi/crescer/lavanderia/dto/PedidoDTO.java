package br.com.cwi.crescer.lavanderia.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;

public class PedidoDTO {
	
	@NotNull
	@NotBlank
	private Long idPedido;
	
	@NotNull
	@NotBlank
	private ClienteDTO cliente;
	
	@NotNull
	@NotBlank
	private List<ItemDTO> itens;
	
	@NotNull
	@NotBlank
	private Date dataInclusao;
	
	
	private Date dataEntrega;
	
	@NotNull
	@NotBlank
	private BigDecimal valorBruto;
	
    private SituacaoPedido situacao;
    
	private BigDecimal valorDesconto;
	
	private BigDecimal valorFinal;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	
	public List<ItemDTO> getItens() {
		return itens;
	}
	
	public void setItens(List<ItemDTO> itens) {
		this.itens = itens;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}

	public SituacaoPedido getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPedido situacao) {
		this.situacao = situacao;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}
}
