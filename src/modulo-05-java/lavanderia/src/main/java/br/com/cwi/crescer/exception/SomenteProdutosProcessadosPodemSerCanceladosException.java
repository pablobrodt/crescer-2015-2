package br.com.cwi.crescer.exception;

import br.com.cwi.crescer.exception.Mensagem.TipoMensagem;

public class SomenteProdutosProcessadosPodemSerCanceladosException extends PedidoException{
	
	public SomenteProdutosProcessadosPodemSerCanceladosException() {
		String mensagem = "Somente pedidos já processados podem ser encerrados.";
		this.mensagem = new Mensagem(mensagem, TipoMensagem.WARNING);
	}
	
}
