package br.com.cwi.crescer.exception;

import br.com.cwi.crescer.exception.Mensagem.TipoMensagem;

public class PedidoJaProcessadoException extends PedidoException {

	public PedidoJaProcessadoException() {
		String mensagem = "Este pedido já foi processado.";
		this.mensagem = new Mensagem(mensagem, TipoMensagem.WARNING);
	}
	
}
