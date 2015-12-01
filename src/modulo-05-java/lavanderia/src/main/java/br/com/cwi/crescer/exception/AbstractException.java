package br.com.cwi.crescer.exception;

public class AbstractException extends Exception{
	
	protected Mensagem mensagem;
	
	public Mensagem getMensagem() {
		return mensagem;
	}
	
}
