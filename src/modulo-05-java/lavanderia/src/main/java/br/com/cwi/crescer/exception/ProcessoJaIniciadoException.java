package br.com.cwi.crescer.exception;

import br.com.cwi.crescer.exception.Mensagem.TipoMensagem;

public class ProcessoJaIniciadoException extends PedidoException {

	public ProcessoJaIniciadoException() {
		String mensagem = "O procedimento de processamento dos itens já foi iniciado.";
		this.mensagem = new Mensagem(mensagem, TipoMensagem.WARNING);
	}
	
}
