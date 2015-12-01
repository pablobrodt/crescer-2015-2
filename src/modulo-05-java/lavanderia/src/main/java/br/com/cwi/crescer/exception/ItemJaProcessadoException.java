package br.com.cwi.crescer.exception;

import br.com.cwi.crescer.exception.Mensagem.TipoMensagem;

public class ItemJaProcessadoException extends ItemException {
	
	public ItemJaProcessadoException() {
		String mensagem = "O item já está sendo processado.";
		this.mensagem = new Mensagem(mensagem, TipoMensagem.WARNING);
	}
	
}
