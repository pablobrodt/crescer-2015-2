package br.com.cwi.crescer.exception;

import br.com.cwi.crescer.exception.Mensagem.TipoMensagem;

public class PedidoDescontoException extends PedidoException{

	public PedidoDescontoException() {
		String mensagem = "O valor bruto do pedido deve ser calculado antes do desconto.";
		this.mensagem = new Mensagem(mensagem, TipoMensagem.ERROR);
	}
}
